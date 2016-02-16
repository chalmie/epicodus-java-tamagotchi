public class Tamagotchi {
  private String mName;
  private Integer mFoodLevel = 10;
  private Integer mSleepLevel = 10;
  private Integer mActivityLevel = 10;

  public Tamagotchi(String name) {
    mName = name;
  }

  public String getName() {
    return mName;
  }
  public Integer getFoodLevel() {
    return mFoodLevel;
  }
  public Integer getSleepLevel() {
    return mSleepLevel;
  }
  public Integer getActivityLevel() {
    return mActivityLevel;
  }
  public void setName(String name) {
    mName = name;
  }
  public void setFoodLevel(Integer newFoodLevel) {
    mFoodLevel = newFoodLevel;
  }
  public void setSleepLevel(Integer newSleepLevel) {
    mSleepLevel = newSleepLevel;
  }
  public void setActivityLevel(Integer newActivityLevel) {
    mActivityLevel = newActivityLevel;
  }
}
