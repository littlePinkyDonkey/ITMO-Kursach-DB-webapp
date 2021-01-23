package andrei.teplyh.dto;

public class ProductDTO {
    private String description;
    private String authorName;
    private String productName;
    private int productId;

    public ProductDTO() {
    }
    public ProductDTO(String description, String authorName, String productName, int productId) {
        this.description = description;
        this.authorName = authorName;
        this.productName = productName;
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
}
