package com.linwu.project.building.projectbuilding.utils;

import com.linwu.project.building.projectbuilding.model.base.UserContext;
import lombok.NoArgsConstructor;

/**
 * @author ：林雾
 * @date ：2019/05/30
 * @description :
 */
@NoArgsConstructor
public class UserContextHolder {
  private static final ThreadLocal<UserContext> USERCONTEXT_HOLDER = new ThreadLocal();

  public static void resetUsercontext() {
    USERCONTEXT_HOLDER.remove();
  }

  public static void setUsercontext(UserContext userContext) {
    USERCONTEXT_HOLDER.set(userContext);
  }

  public static UserContext getUserContext() {
    return USERCONTEXT_HOLDER.get();
  }
}
