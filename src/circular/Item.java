package circular;

public class Item {
    private String category;
    private String description;
    private boolean available = true;

    public Item(String category, String description){
        this.category = category;
        this.description = description;
    }

    public String toString(){
        return category + ", " + description + ", " + available;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public boolean getAvailable(){
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
