package test.nbaplayers.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta
{
   @SerializedName("total_pages")
   @Expose
   private Integer totalPages;
   @SerializedName("current_page")
   @Expose
   private Integer currentPage;
   @SerializedName("next_page")
   @Expose
   private Integer nextPage;
   @SerializedName("per_page")
   @Expose
   private Integer perPage;
   @SerializedName("total_count")
   @Expose
   private Integer totalCount;

   public Integer getTotalPages() {
      return totalPages;
   }

   public Integer getCurrentPage() {
      return currentPage;
   }

   public Integer getNextPage() {
      return nextPage;
   }

   public Integer getPerPage() {
      return perPage;
   }

   public Integer getTotalCount() {
      return totalCount;
   }
}
