package model;

public class Post {
    private Long ID;
    private String imageUrl;
    private String description;

    public Post() {
    }

    public Post(Long ID, String imageUrl, String description) {
        this.ID = ID;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        int count =1;
        return "\nPost{" +
                "id=" + ID +
                ", imageUrl='" + imageUrl  +
                ", description='" + description  +
                '}';
    }
}