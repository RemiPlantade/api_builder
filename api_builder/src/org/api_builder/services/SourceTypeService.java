package org.api_builder.services;

import org.api_builder.beans.SourceType;

public interface SourceTypeService {
	public SourceType saveSourceType(SourceType sourceType);
	public SourceType getSourceTypeById(int id);
}
