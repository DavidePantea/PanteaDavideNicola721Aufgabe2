public class Medikamente {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getKrankenheit() {
        return krankenheit;
    }

    public void setKrankenheit(String krankenheit) {
        this.krankenheit = krankenheit;
    }

    private String name;
    private Integer price;
    private String krankenheit;

    public Medikamente(String name, Integer price, String krankenheit) {
        this.name = name;
        this.price = price;
        this.krankenheit = krankenheit;
    }


}
