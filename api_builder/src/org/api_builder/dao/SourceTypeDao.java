package org.api_builder.dao;

import org.api_builder.beans.SourceType;

public interface SourceTypeDao {
	public SourceType add(SourceType sourceType);
	public SourceType findById(int id);
}
