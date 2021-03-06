package circular;

public class Catalogue {
  private final Item[] itemList;

  public Catalogue(int catalogueSize) {
    this.itemList = new Item[catalogueSize];
  }

  public int arrayIndexOf(Item[] arrayIn, Item input) {
    for (int i = 0; i < arrayIn.length; i++) {
      if (arrayIn[i] == input) {
        return i;
      }
    }
    return -1;
  }

  public Item[] getFullList() {
    return this.itemList;
  }

  public Item findItem(String input) {
    for (int i = 0; i < this.itemList.length; i++) {
      if (this.itemList[i].getDescription().equals(input)) {
        return this.itemList[i];
      }
    }
    return null;
  }

  public Item[] getAvailableItems() {
    Item[] availableItems;
    int j = 0;
    int k = 0;
    for (int i = 0; i < this.itemList.length; i++) {
      if (this.itemList[i] != null && this.itemList[i].getAvailable()) {
        j++;
      }
    }
    availableItems = new Item[j];
    for (int i = 0; i < this.itemList.length; i++) {
      if (this.itemList[i] != null && this.itemList[i].getAvailable()) {
        availableItems[k] = this.itemList[i];
        k++;
      }
    }
    return availableItems;
  }

  public void borrowItem(Item input) {
    input.setAvailable(false);
  }

  public void returnItem(Item input) {
    input.setAvailable(true);
  }

  public void addItem(Item input) {
    this.itemList[arrayIndexOf(this.itemList, null)] = input;
  }
}
