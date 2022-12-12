package pttk.dao.book.impl;

import pttk.dao.BaseDAOImpl;
import pttk.dao.book.PublisherDAO;
import pttk.model.book.Publisher;
import pttk.util.impl.PublisherMapper;

import java.util.List;

public class PublisherDAOImpl extends BaseDAOImpl<Publisher> implements PublisherDAO {
    @Override
    public Publisher getPublisherById(int publisherId) {
        String sql = "SELECT * FROM Publisher WHERE ID = ?";
        List<Publisher> publisherList =  query(sql, new PublisherMapper(), publisherId);
        return publisherList.isEmpty() ? null : publisherList.get(0);
    }

    @Override
    public Publisher save(Publisher publisher) {
        String sql = "INSERT INTO Publisher( Name, Address) VALUE( ?, ?)";
        Long id = insert(sql, publisher.getName(), publisher.getAddress());
        return getPublisherById(Math.toIntExact(id));
    }

    @Override
    public Publisher update(Publisher publisher) {
        String sql = "UPDATE Author SET Name = ?, Address = ? WHERE ID = ?";
        update(sql, publisher.getName(), publisher.getAddress(), publisher.getId());
        return publisher;
    }

}
