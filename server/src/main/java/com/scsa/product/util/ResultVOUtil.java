package com.scsa.product.util;

import com.scsa.product.VO.ResultVO;

/**
 * @Author: SCSA
 * @Date: 2020/8/19 23:03
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
