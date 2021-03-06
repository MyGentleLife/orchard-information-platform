package com.liyang.orchard.service.impl;

import com.liyang.orchard.dao.BrowseRecordsMapper;
import com.liyang.orchard.model.BrowseRecords;
import com.liyang.orchard.service.BrowseRecordsService;
import com.liyang.orchard.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Liyang on 2021/01/25.
 */
@Service
@Transactional
public class BrowseRecordsServiceImpl extends AbstractService<BrowseRecords> implements BrowseRecordsService {
    @Resource
    private BrowseRecordsMapper browseRecordsMapper;


}
