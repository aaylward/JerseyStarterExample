package com.andyaylward.data;

public class Wocket {
  private String name;

  public Wocket() {
  }

  public Wocket(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (!(object instanceof Wocket)) {
      return false;
    }
    Wocket o = (Wocket)object;
    return getName().equals(o.getName());
  }
}
