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
  public void addFoodLevel() {
      mFoodLevel = mFoodLevel + 2;
  }
  public void addSleepLevel() {
      mSleepLevel = mSleepLevel + 2;
  }
  public void addActivityLevel() {
      mActivityLevel = mActivityLevel + 2;
  }

  public Boolean isAlive() {
    if(mFoodLevel <= 0 || mSleepLevel <= 0 || mActivityLevel <= 0) {
      return false;
    } else {
      return true;
    }
  }

  public void decreaseLevels() {
    mFoodLevel = mFoodLevel - 1;
    mSleepLevel = mSleepLevel - 1;
    mActivityLevel = mActivityLevel - 1;
  }
}
