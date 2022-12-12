package pttk.dao.book;

import pttk.dao.BaseDAO;
import pttk.model.book.Publisher;

public interface PublisherDAO extends BaseDAO<Publisher> {
    Publisher getPublisherById(int publisherId);
    Publisher save(Publisher publisher);
    Publisher update(Publisher publisher);
}
