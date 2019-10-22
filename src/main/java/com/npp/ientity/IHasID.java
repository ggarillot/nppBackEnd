package com.npp.ientity;

import java.io.Serializable;

public interface IHasID<I> extends Serializable {
	public I getId();

	public void setId(I id);
}
