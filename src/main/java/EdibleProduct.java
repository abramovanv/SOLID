public class EdibleProduct extends Product implements Delivery {//Open Closed Principle имлементацией добавляем новый фукнционал не изменяя старый

    protected boolean isEdible = true;

    public EdibleProduct(String nameProduct, int priceProduct, boolean isEdible) {
        super(nameProduct, priceProduct);
        this.isEdible = isEdible;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public void setEdible(boolean edible) {
        isEdible = edible;
    }

    @Override
    public void deliver() {
        if (isEdible()) {
            System.out.println("Доставка не возможна");
        }
    }

}
