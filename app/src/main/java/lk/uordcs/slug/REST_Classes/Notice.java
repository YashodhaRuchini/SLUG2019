package lk.uordcs.slug.REST_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Notice {

    @SerializedName("notices")
    @Expose
    private List<Notice_> notices = null;

    public List<Notice_> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice_> notices) {
        this.notices = notices;
    }

}