package pttk.dao.electronic;

import pttk.dao.BaseDAO;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;

public interface ComputerDAO extends BaseDAO<Computer> {
    Computer findComputerByElectronicId (Electronic electronic);
    Computer updateComputer(Computer computer);
    void deleteComputer(int electronicId);
}
