package javaexample;


public class Car implements Comparable<Car>{
  private Integer tier;

  public Integer getTier() {
    return tier;
  }

  public void setTier(Integer tier) {
    this.tier = tier;
  }

  @Override
  public int compareTo(Car o) {
    return tier.compareTo(o.getTier());
  }
}
