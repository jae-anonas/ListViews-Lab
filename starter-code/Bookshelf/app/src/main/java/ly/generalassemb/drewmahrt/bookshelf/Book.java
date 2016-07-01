package ly.generalassemb.drewmahrt.bookshelf;

/**
 * Created by drewmahrt on 12/16/15.
 */
public class Book {
    private String mTitle;
    private String mAuthor;
    private int mCoverResourceId;

    public Book(String title,String author, int resourceId){
        mTitle = title;
        mAuthor = author;
        mCoverResourceId = resourceId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public int getResourceId(){
        return mCoverResourceId;
    }

}
