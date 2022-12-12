package pttk.dao.electronic;

import pttk.dao.BaseDAO;
import pttk.model.electronic.Electronic;
import pttk.model.electronic.Mobile;

public interface MobileDAO extends BaseDAO<Mobile> {
    Mobile findMobileByElectronicId(Electronic electronic);
    Mobile updateMobile(Mobile mobile);
    void deleteMobile(int electronicId);
}
