package com.team.hk.sys.contorller.impl;

import com.team.hk.common.Constant;
import com.team.hk.sys.contorller.SysUserInfoController;
import com.team.hk.sys.entity.SysUserInfo;
import com.team.hk.sys.server.SysUserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lidongliang on 2017/7/16.
 * 系统用户信息实现类
 */
@Controller
@RequestMapping("/api/sysUser")
public class SysUserInfoControllerImpl implements SysUserInfoController {

    private static Logger logger = Logger.getLogger(SysUserInfoControllerImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SysUserInfoService sysUserInfoService;


    /**
     * 获得系统用户信息（通过分页）
     *
     * @param sysUserInfo 系统用户entity
     * @param pageNo      页数
     * @param pageSize    数量
     * @return List<SysUserInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @Override
    public List<SysUserInfo> getAllSysUserInfoByPage(@RequestBody SysUserInfo sysUserInfo, @PathVariable("pageNo") Long pageNo,
                                                     @PathVariable("pageSize") Long pageSize, HttpServletRequest request) {
        List list = new ArrayList();
        Long userId = Long.valueOf(request.getSession().getAttribute("userId").toString());
        String userRole = (String) request.getSession().getAttribute("userRole");

        if (userRole != null && userRole.contains("admin")) {
            sysUserInfo.setParentId(userId);
            sysUserInfo.setUserType(Constant.USER_TYPE_BOSS);
        } else if (userRole != null && userRole.contains("boss")) {
            sysUserInfo.setParentId(userId);
            sysUserInfo.setUserType(Constant.USER_TYPE_STORE);
        } else if (userRole != null && userRole.contains("user")) {
            sysUserInfo.setUserId(userId);
        }

        List<SysUserInfo> sysUserInfos = sysUserInfoService.getAllSysUserInfoByPageService(sysUserInfo, pageNo, pageSize);
        int count = sysUserInfoService.getAllSysUserInfoCountByPageService(sysUserInfo, pageNo, pageSize);
        list.add(sysUserInfos);
        list.add(count);
        return list;
    }

    /**
     * 获得系统用户信息
     *
     * @param sysUserInfo 系统用户entity
     * @return List<SysUserInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Override
    public List<SysUserInfo> getAllSysUserInfo(@RequestBody SysUserInfo sysUserInfo, HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        sysUserInfo.setUserId(Long.parseLong(userId));
        return sysUserInfoService.getAllSysUserInfoService(sysUserInfo);
    }


    /**
     * 增加系统用户信息
     *
     * @param sysUserInfo 系统用户entity
     * @return List<SysUserInfo>
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public List<SysUserInfo> addSysUserInfo(@RequestBody SysUserInfo sysUserInfo, HttpServletRequest request) {

        Long userId = Long.valueOf(request.getSession().getAttribute("userId").toString());
        String userRole = (String) request.getSession().getAttribute("userRole");

        if (userRole != null && userRole.contains("admin")) {
            sysUserInfo.setParentId(userId);
            sysUserInfo.setUserType(Constant.USER_TYPE_BOSS);
            sysUserInfo.setUserRole(Constant.ROULE_BOSS);
        } else if (userRole != null && userRole.contains("boss")) {
            sysUserInfo.setParentId(userId);
            sysUserInfo.setUserType(Constant.USER_TYPE_STORE);
            sysUserInfo.setUserRole(Constant.ROULE_USER);
        }

        return sysUserInfoService.addSysUserInfoService(sysUserInfo);
    }

    /**
     * 修改系统用户信息
     *
     * @param sysUserInfo 系统用户entity
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public int updateSysUserInfo(@RequestBody SysUserInfo sysUserInfo) {
        return sysUserInfoService.updateSysUserInfoService(sysUserInfo);
    }

    /**
     * 删除一个系统用户信息
     *
     * @param userId 系统用户ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    @Override
    public int deleteSysUserInfoById(@PathVariable("userId") Long userId) {
        return sysUserInfoService.deleteSysUserInfoByIdService(userId);
    }

    /**
     * 删除多个系统用户
     *
     * @param userId 系统用户ID
     * @return rowsAffected
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @Override
    public int deleteSysUserInfoByIds(@RequestParam("userId") List<Long> userId) {
        return sysUserInfoService.deleteSysUserInfoByIdsService(userId);
    }
}
