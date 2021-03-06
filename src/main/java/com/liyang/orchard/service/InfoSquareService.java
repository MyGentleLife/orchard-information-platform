package com.liyang.orchard.service;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.model.InfoSquare;
import com.liyang.orchard.core.Service;
import com.liyang.orchard.model.infosquare.*;
import com.liyang.orchard.model.infosquare.vo.MyInfoSquare;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Liyang on 2021/01/25.
 */
public interface InfoSquareService extends Service<InfoSquare> {

    DetailsInfoSquare selectDetailsInfoSquareById(Integer id);

    void insertBuyInfoSquare(BuyInfoSquare buyInfoSquare);

    void insertSupplyInfoSquare(SupplyInfoSquare supplyInfoSquare);

    void insertLabourInfoSquare(LabourInfoSquare labourInfoSquare);

    void insertLeaseInfoSquare(LeaseInfoSquare leaseInfoSquare);

    void insertTransferInfoSquare(TransferInfoSquare transferInfoSquare);

    List<MyInfoSquare> selectMyInfoSquareList(Integer userId);

    InfoSquare selectInfoSquareAllById(Integer infoId);

    Result updateInfoSquare(UpdateInfoSquare updateInfoSquare);
    
    List<SearchInfoSquare> searchInfoSquare(String queryText, Integer infoType);
}
