package com.studentmanagement.models;

import java.util.List;

public interface Model<T> {

	public void save(T obj);
	public void update(T obj);
	public void delete(T obj);
	public T find(int id);
	public List<T> findAll();
}
