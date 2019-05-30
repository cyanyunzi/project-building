package com.linwu.project.building.projectbuilding.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：林雾
 * @date ：2019/05/30
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserContext {
  private String username;
  private String userId;
}
