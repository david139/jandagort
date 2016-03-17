package com.jandagort.planets.types;

import java.math.BigDecimal;

public abstract class Planet {
    private PlanetTypeName type;

    private BigDecimal wood;
    private BigDecimal stone;
    private BigDecimal food;

    private BigDecimal woodProduction = new BigDecimal(100);
    private BigDecimal stoneProduction = new BigDecimal(100);
    private BigDecimal foodProduction = new BigDecimal(100);


    public BigDecimal getFood() {
        return food;
    }

    public void setFood(BigDecimal food) {
        this.food = food;
    }

    public BigDecimal getFoodProduction() {
        return foodProduction;
    }

    public void setFoodProduction(BigDecimal foodProduction) {
        this.foodProduction = foodProduction;
    }

    public BigDecimal getStone() {
        return stone;
    }

    public void setStone(BigDecimal stone) {
        this.stone = stone;
    }

    public BigDecimal getStoneProduction() {
        return stoneProduction;
    }

    public void setStoneProduction(BigDecimal stoneProduction) {
        this.stoneProduction = stoneProduction;
    }

    public PlanetTypeName getType() {
        return type;
    }

    public void setType(PlanetTypeName type) {
        this.type = type;
    }

    public BigDecimal getWood() {
        return wood;
    }

    public void setWood(BigDecimal wood) {
        this.wood = wood;
    }

    public BigDecimal getWoodProduction() {
        return woodProduction;
    }

    public void setWoodProduction(BigDecimal woodProduction) {
        this.woodProduction = woodProduction;
    }
}
