/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pttk.dao.clothes;

import pttk.dao.BaseDAO;
import pttk.model.clothes.Origin;

/**
 *
 * @author Admin88
 */
public interface OriginDAO  extends BaseDAO<Origin>{
    Origin getOriginById(int originId);
    Origin save(Origin origin);
    Origin update(Origin origin);
}
