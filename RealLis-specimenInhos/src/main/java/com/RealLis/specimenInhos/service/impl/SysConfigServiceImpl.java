package com.RealLis.specimenInhos.service.impl;

import com.RealLis.common.annotation.DataSource;
import com.RealLis.common.constant.Constants;
import com.RealLis.common.constant.UserConstants;
import com.RealLis.common.core.text.Convert;
import com.RealLis.common.enums.DataSourceType;
import com.RealLis.common.utils.CacheUtils;
import com.RealLis.common.utils.StringUtils;
import com.RealLis.specimenInhos.domain.SysConfig;
import com.RealLis.specimenInhos.mapper.SysConfigMapper;
import com.RealLis.specimenInhos.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 参数配置 服务层实现
 */
@Service
@DataSource(value = DataSourceType.SLAVE)
public class SysConfigServiceImpl implements ISysConfigService
{
    @Autowired
    private SysConfigMapper configMapper;

    @Override
    public String selectConfigByKey(String configKey) {
        return null;
    }

    @Override
    public int insertConfig(SysConfig config) {
        return 0;
    }

    @Override
    public int updateConfig(SysConfig config) {
        return 0;
    }

    @Override
    public int deleteConfigByIds(String ids) {
        return 0;
    }

    @Override
    public void clearCache() {

    }

    /**
     * 查询参数配置信息
     *
     * @param configId 参数配置ID
     * @return 参数配置信息
     */
    @Override
    public SysConfig selectConfigById(Long configId)
    {
        SysConfig config = new SysConfig();
        config.setConfigId(configId);
        return configMapper.selectConfig(config);
    }


    /**
     * 查询参数配置列表
     *
     * @param config 参数配置信息
     * @return 参数配置集合
     */
    @Override
    public List<SysConfig> selectConfigList(SysConfig config)
    {
        return configMapper.selectConfigList(config);
    }








    /**
     * 校验参数键名是否唯一
     *
     * @param config 参数配置信息
     * @return 结果
     */
    @Override
    public String checkConfigKeyUnique(SysConfig config)
    {
        Long configId = StringUtils.isNull(config.getConfigId()) ? -1L : config.getConfigId();
        SysConfig info = configMapper.checkConfigKeyUnique(config.getConfigKey());
        if (StringUtils.isNotNull(info) && info.getConfigId().longValue() != configId.longValue())
        {
            return UserConstants.CONFIG_KEY_NOT_UNIQUE;
        }
        return UserConstants.CONFIG_KEY_UNIQUE;
    }



}
