package pttk.dao.electronic;

import pttk.dao.BaseDAO;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;

public interface ElectronicDAO extends BaseDAO<Electronic> {
    Electronic findElectronicByItemElectronicId(int ItemElectronicId);
    Electronic findElectronicById(int electronicId);
    Electronic getMobileByItemElectronicId(int itemElectronicId);
    Electronic getComputerByItemElectronicId(int itemElectronicId);
    Electronic updateElectronic(Electronic electronic);
    void deleteElectronic(int itemElectronicId);
}
