package application.message;

import messaging.message.IPMessage;
import messaging.message.UpdateMessage;
import messaging.message.MessageGid;
import storage.datastructure.MultipartTimestamp;

public class UpdateAckMessage extends IPMessage  {
	private static final long serialVersionUID = -8130291980160771455L;

	// the identifier of {@link UpdateMessage}
	private final MessageGid umid;
	// the timestamp of {@link UpdateMessage}
	private final MultipartTimestamp ts;

	public UpdateAckMessage(MessageGid umid, MultipartTimestamp mpts)
	{
		super(null);	// no need to carry the sender's address (i.e., ip + port)
		this.umid = umid;
		this.ts = mpts;
	}

	public UpdateAckMessage(UpdateMessage update_msg)
	{
		this(update_msg.getMsgGid(), update_msg.getUpdateTs());
	}

	public MessageGid getUmid()
	{
		return this.umid;
	}

	public MultipartTimestamp getUpdateTs()
	{
		return this.ts;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("UpdateAckMesssageId: ").append(this.umid.toString()).append(";")
			.append("Ts: ").append(this.ts.toString());

		return sb.toString();
	}
}