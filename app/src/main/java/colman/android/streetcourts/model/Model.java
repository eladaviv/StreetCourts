package colman.android.streetcourts.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import colman.android.streetcourts.MyApplication;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Model {
    public static final Model instance = new Model();
    public Executor executor = Executors.newFixedThreadPool(1);
    public Handler mainThread = HandlerCompat.createAsync(Looper.getMainLooper());

    ModelFirebase modelFirebase = new ModelFirebase();

    MutableLiveData<List<Member>> membersList = new MutableLiveData<List<Member>>();


    public enum MembersListLoadingState {
        loading,
        loaded
    }

    MutableLiveData<MembersListLoadingState> membersListLoadingState = new MutableLiveData<>();

    private Model() {
        membersListLoadingState.setValue(MembersListLoadingState.loaded);
        postsListLoadingState.setValue(PostsListLoadingState.loaded);
    }

    public MutableLiveData<MembersListLoadingState> getMembersListLoadingState() {
        return membersListLoadingState;
    }

    public LiveData<List<Member>> getAllMembers() {
        refreshMembersList();
        return membersList;
    }

    public void refreshMembersList() {
        membersListLoadingState.setValue(MembersListLoadingState.loading);

        // get last local update date
        Long lastUpdateDate = MyApplication.getContext().getSharedPreferences("TAG", Context.MODE_PRIVATE).getLong("MemberLastUpdateDate", 0);

        // firebase get all updates since last local update date
        modelFirebase.getAllMembers(lastUpdateDate, list -> {

            // add all records to the local db
            executor.execute(() -> {
                Long localUpdateDate = new Long(0);
                for (Member member : list) {
                    Log.d("TAG", "Found Member : "+ member.name);
                    if (!member.isDeleted())
                        AppLocalDb.db.memberDao().insertAll(member);
                    else
                        AppLocalDb.db.memberDao().delete(member);
                    if (localUpdateDate < member.getUpdateDate()) {
                        localUpdateDate = member.getUpdateDate();
                    }
                }

                // update last local update date
                MyApplication.getContext()
                        .getSharedPreferences("TAG", Context.MODE_PRIVATE)
                        .edit()
                        .putLong("MemberLastUpdateDate", localUpdateDate)
                        .commit();

                // return all data to caller
                List<Member> updatedList = AppLocalDb.db.memberDao().getAllMembers();
                membersList.postValue(updatedList);
                membersListLoadingState.postValue(MembersListLoadingState.loaded);
            });
        });
    }

    public interface SaveImageListener {
        void onComplete(String url);
    }

    public void saveImage(Bitmap imageBitmap, String imageName, SaveImageListener listener) {
        modelFirebase.saveImage(imageBitmap, imageName, listener);
    }

    MutableLiveData<Member> retMember = new MutableLiveData<Member>();

    public LiveData<Member> getMemberById(String id) {
        boolean flag = false;
        if (membersList.getValue() == null) {
            refreshMembersList();
        }
        refreshMembersList();
        if (membersList.getValue() != null) {
            for (Member member : membersList.getValue()) {
                if (member.getId().equals(id)) {
                    retMember.setValue(member);
                    flag = true;
                }
            }
        }
        if (!flag) retMember.postValue(null);
        return retMember;
    }

    public interface AddMemberListener {
        void onComplete();
    }

    public void addMember(Member member, AddMemberListener listener) {
        modelFirebase.addMember(member, () -> {
            refreshMembersList();
            listener.onComplete();
        });
    }

    public interface DeleteListener {
        void onComplete(Exception e);
    }

    public void delete(Member member, DeleteListener listener) {
        modelFirebase.delete(member, listener);
    }

    public interface LogicalDeleteListener {
        void onComplete();
    }

    public void logicalDelete(Member member, LogicalDeleteListener listener) {
        modelFirebase.logicalDelete(member, () -> {
            refreshMembersList();
            listener.onComplete();
        });
    }

    public interface GetMemberByIdListener {
        void onComplete(boolean isDeleted);
    }

    public interface GetFullMemberByIdListener {
        void onComplete(Member member);
    }

    public void isMemberDeletedFromDb(Member member, GetMemberByIdListener listener) {
        if (member == null) {
            listener.onComplete(true);
            return;
        }
        modelFirebase.getMemberById(member.getId(), member.getUpdateDate(), listener);
    }

    /***************POST MODEL*****************/
    public enum PostsListLoadingState {
        loading,
        loaded
    }

    MutableLiveData<PostsListLoadingState> postsListLoadingState = new MutableLiveData<>();
    MutableLiveData<List<Post>> postsList = new MutableLiveData<List<Post>>();

    public interface AddPostListener {
        void onComplete();
    }

    public void addPost(Post post, AddPostListener listener) {
        modelFirebase.addPost(post, () -> {
            refreshPostsList();
            listener.onComplete();
        });
    }

    public interface PostDeleteListener {
        void onComplete();
    }

    public void postDelete(Post post, PostDeleteListener listener) {
        modelFirebase.postDelete(post, listener);
    }

    public MutableLiveData<PostsListLoadingState> getPostsListLoadingState() {
        return postsListLoadingState;
    }

    public void refreshPostsList() {
        postsListLoadingState.setValue(PostsListLoadingState.loading);

        // get last local update date
        Long lastUpdateDate = MyApplication.getContext().getSharedPreferences("TAG", Context.MODE_PRIVATE).getLong("PostLastUpdateDate", 0);

        executor.execute(() -> {
            List<Post> updatedList = AppLocalDb.db.postDao().getAllPosts();
            postsList.postValue(updatedList);
        });

        // firebase get all updates since last local update date
        modelFirebase.getAllPosts(lastUpdateDate, list -> {

            // add all records to the local db
            executor.execute(() -> {
                Long localUpdateDate = new Long(0);
                for (Post post : list) {
                    if (!post.isDeleted())
                        AppLocalDb.db.postDao().insertAll(post);
                    else
                        AppLocalDb.db.postDao().delete(post);
                    if (localUpdateDate < post.getUpdateDate()) {
                        localUpdateDate = post.getUpdateDate();
                    }
                }

                // update last local update date
                MyApplication.getContext()
                        .getSharedPreferences("TAG", Context.MODE_PRIVATE)
                        .edit()
                        .putLong("PostLastUpdateDate", localUpdateDate)
                        .commit();

                // return all data to caller
                List<Post> updatedList = AppLocalDb.db.postDao().getAllPosts();
                postsList.postValue(updatedList);
                postsListLoadingState.postValue(PostsListLoadingState.loaded);
            });
        });
    }

    public LiveData<List<Post>> getAllPosts() {
        refreshPostsList();
        return postsList;
    }

    MutableLiveData<List<Post>> postsByCategoryList = new MutableLiveData<List<Post>>();

    public void refreshPostsByCategory(String category) {
        postsListLoadingState.setValue(PostsListLoadingState.loading);

        // get last local update date
        Long lastUpdateDate = MyApplication.getContext().getSharedPreferences("TAG", Context.MODE_PRIVATE).getLong("PostLastUpdateDate", 0);

        executor.execute(() -> {
            List<Post> updatedList = AppLocalDb.db.postDao().getAllPosts();
            postsList.postValue(updatedList);
        });

        // firebase get all updates since last local update date
        modelFirebase.getAllPosts(lastUpdateDate, list -> {

            // add all records to the local db
            executor.execute(() -> {
                Long localUpdateDate = new Long(0);
                for (Post post : list) {
                    if (!post.isDeleted())
                        AppLocalDb.db.postDao().insertAll(post);
                    else
                        AppLocalDb.db.postDao().delete(post);
                    if (localUpdateDate < post.getUpdateDate()) {
                        localUpdateDate = post.getUpdateDate();
                    }
                }

                // update last local update date
                MyApplication.getContext()
                        .getSharedPreferences("TAG", Context.MODE_PRIVATE)
                        .edit()
                        .putLong("PostLastUpdateDate", localUpdateDate)
                        .commit();

                // return all data to caller
                List<Post> updatedList = AppLocalDb.db.postDao().getAllPosts();
                postsList.postValue(updatedList);
                ArrayList<Post> filteredList = new ArrayList<Post>();
                if (updatedList != null) {
                    for (Post post : updatedList) {
                        if (post.getCategory().equals(category)) {
                            filteredList.add(post);
                        }
                    }
                }
                postsByCategoryList.postValue(filteredList);
                postsListLoadingState.postValue(PostsListLoadingState.loaded);
            });
        });
    }

    public LiveData<List<Post>> getPostsByCategory(String category) {
        refreshPostsByCategory(category);
        return postsByCategoryList;
    }

    MutableLiveData<List<Post>> postsByMemberList = new MutableLiveData<List<Post>>();

    public void refreshPostsByMember(String memberId) {
        postsListLoadingState.setValue(PostsListLoadingState.loading);

        // get last local update date
        Long lastUpdateDate = MyApplication.getContext().getSharedPreferences("TAG", Context.MODE_PRIVATE).getLong("PostLastUpdateDate", 0);

        executor.execute(() -> {
            List<Post> updatedList = AppLocalDb.db.postDao().getAllPosts();
            postsList.postValue(updatedList);
        });

        // firebase get all updates since last local update date
        modelFirebase.getAllPosts(lastUpdateDate, list -> {

            // add all records to the local db
            executor.execute(() -> {
                Long localUpdateDate = new Long(0);
                for (Post post : list) {
                    if (!post.isDeleted())
                        AppLocalDb.db.postDao().insertAll(post);
                    else
                        AppLocalDb.db.postDao().delete(post);
                    if (localUpdateDate < post.getUpdateDate()) {
                        localUpdateDate = post.getUpdateDate();
                    }
                }

                // update last local update date
                MyApplication.getContext()
                        .getSharedPreferences("TAG", Context.MODE_PRIVATE)
                        .edit()
                        .putLong("PostLastUpdateDate", localUpdateDate)
                        .commit();

                // return all data to caller
                List<Post> updatedList = AppLocalDb.db.postDao().getAllPosts();
                postsList.postValue(updatedList);
                ArrayList<Post> filteredList = new ArrayList<Post>();
                if (updatedList != null) {
                    for (Post post : updatedList) {
                        if (post.getUserId().equals(memberId)) {
                            filteredList.add(post);
                        }
                    }
                }
                postsByMemberList.postValue(filteredList);
                postsListLoadingState.postValue(PostsListLoadingState.loaded);
            });
        });
    }

    public LiveData<List<Post>> getPostsByMember(String memberId) {
        refreshPostsByMember(memberId);
        return postsByMemberList;
    }

    MutableLiveData<Post> retPost = new MutableLiveData<Post>();

    public LiveData<Post> getPostById(String id) {

        refreshPostsList();
        for (Post post : postsList.getValue()) {
            if (post.getId().equals(id)) {
                retPost.postValue(post);
            }
        }
        return retPost;
    }

    public interface GetPostByIdListener {
        void onComplete(boolean isDeleted);
    }

    public void isPostDeletedFromDb(Post post, GetPostByIdListener listener) {
        if (post == null) {
            listener.onComplete(true);
            return;
        }
        modelFirebase.getPostById(post.getId(), post.getUpdateDate(), listener);
    }

    /***********Category************/
    public enum CategoriesListLoadingState {
        loading,
        loaded
    }

    MutableLiveData<List<Category>> categoriesList = new MutableLiveData<List<Category>>();
    MutableLiveData<CategoriesListLoadingState> categoriesListLoadingState = new MutableLiveData<CategoriesListLoadingState>();

    public void refreshCategoriesList() {
        categoriesListLoadingState.setValue(CategoriesListLoadingState.loading);

        // get last local update date
        Long lastUpdateDate = MyApplication.getContext().getSharedPreferences("TAG", Context.MODE_PRIVATE).getLong("CategoryLastUpdateDate", 0);

        executor.execute(() -> {
            List<Category> updatedList = AppLocalDb.db.categoryDao().getAllCategories();
            categoriesList.postValue(updatedList);
        });
        // firebase get all updates since last local update date
        modelFirebase.getAllCategories(lastUpdateDate, list -> {

            // add all records to the local db
            executor.execute(() -> {
                Long localUpdateDate = new Long(0);
                for (Category category : list) {
                    if (!category.isDeleted())
                        AppLocalDb.db.categoryDao().insertAll(category);
                    else
                        AppLocalDb.db.categoryDao().delete(category);
                    if (localUpdateDate < category.getUpdateDate()) {
                        localUpdateDate = category.getUpdateDate();
                    }
                }

                // update last local update date
                MyApplication.getContext()
                        .getSharedPreferences("TAG", Context.MODE_PRIVATE)
                        .edit()
                        .putLong("CategoryLastUpdateDate", localUpdateDate)
                        .commit();

                // return all data to caller
                List<Category> updatedList = AppLocalDb.db.categoryDao().getAllCategories();
                categoriesList.postValue(updatedList);
                categoriesListLoadingState.postValue(CategoriesListLoadingState.loaded);
            });
        });
    }


    public interface AddCategoryListener {
        void onComplete();
    }

    public void addCategory(Category category, AddCategoryListener listener) {
        modelFirebase.addCategory(category, () -> {
            refreshCategoriesList();
        });
        listener.onComplete();
    }

    public LiveData<List<Category>> getAllCategories() {
        refreshCategoriesList();
        return categoriesList;
    }

    public interface DeleteCategoryListener {
        void onComplete(Exception error);
    }

    public void deleteCategory(Category category, DeleteCategoryListener listener) {
        modelFirebase.deleteCategory(category, listener);
    }

    public MutableLiveData<CategoriesListLoadingState> getCategoriesListLoadingState() {
        return categoriesListLoadingState;
    }

    /********Authentication********/
    public interface SignInListener {
        void onComplete(FirebaseUser user, Exception error);
    }

    public boolean isSignedIn() {
        return modelFirebase.isSignedIn();
    }

    public String getUid() {
        return modelFirebase.getUId();
    }

    public void signIn(@NonNull String email, @NonNull String password, SignInListener listener) {
        modelFirebase.signIn(email, password, listener);
    }

    public void signOut() {
        executor.execute(() -> modelFirebase.signOut());
    }

    public interface RegisterListener {
        void onComplete(FirebaseUser user, Exception error);
    }

    public void register(@NonNull String email, @NonNull String password, RegisterListener listener) {
        modelFirebase.register(email, password, listener);
    }

}