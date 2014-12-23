package es.fjtorres.pruebas.juan.ejemplo.comun;

import java.io.Serializable;
import java.util.List;

public class PageWrapper<T extends Serializable> implements Serializable {

   private static final long serialVersionUID = 1587204223905452704L;

   private long totalResults;

   private int currentPage;

   private int pageSize;

   private List<T> items;

   private String sortField;

   private OrderBy sortDirection;

   public PageWrapper() {

   }

   public PageWrapper(final int currentPage, final int pageSize) {
      super();
      this.currentPage = currentPage;
      this.pageSize = pageSize;
   }

   public PageWrapper(final int currentPage, final int pageSize,
         final String sortField, final OrderBy sortDirection) {
      super();
      this.currentPage = currentPage;
      this.pageSize = pageSize;
      this.sortField = sortField;
      this.sortDirection = sortDirection;
   }

   public long getTotalResults() {
      return totalResults;
   }

   public void setTotalResults(final long totalResults) {
      this.totalResults = totalResults;
   }

   public int getCurrentPage() {
      return currentPage;
   }

   public void setCurrentPage(final int currentPage) {
      this.currentPage = currentPage;
   }

   public int getPageSize() {
      return pageSize;
   }

   public void setPageSize(final int pageSize) {
      this.pageSize = pageSize;
   }

   public List<T> getItems() {
      return items;
   }

   public void setItems(final List<T> items) {
      this.items = items;
   }

   public String getSortField() {
      return sortField;
   }

   public void setSortField(final String sortField) {
      this.sortField = sortField;
   }

   public OrderBy getSortDirection() {
      return sortDirection;
   }

   public void setSortDirection(final OrderBy sortDirection) {
      this.sortDirection = sortDirection;
   }
}
