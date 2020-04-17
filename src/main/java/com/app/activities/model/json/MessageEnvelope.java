package com.app.activities.model.json;

import lombok.Data;

@Data
public class MessageEnvelope <T extends EnvelopeBody > {
	private MessageHeaders header;
	private T body;
}
