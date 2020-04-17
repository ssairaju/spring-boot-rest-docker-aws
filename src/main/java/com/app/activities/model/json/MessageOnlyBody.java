package com.app.activities.model.json;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageOnlyBody implements EnvelopeBody {
	private String message;
}
