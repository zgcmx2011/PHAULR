package messaging.message;

import java.util.Set;

import communication.Address;
import storage.datastructure.MultipartTimestamp;


public class QueryMessage extends IPMessage
{
	private static final long serialVersionUID = 6927273959709196533L;

	private MultipartTimestamp prev;
	private String op;

	/**
	 * Constructor of {@link QueryMessage}
	 *
	 * @param sender_addr {@link Address} of the message sender
	 * @param label
	 * @param operation
	 * @param qmid {@link MessageGid} of this query message
	 */
	public QueryMessage(Address sender_addr, Set<MessageGid> deps, MultipartTimestamp label, String operation, MessageGid qmid)
	{
		super(sender_addr);

		this.prev = label;
		this.op = operation;
		
		super.msg_id = qmid;
		super.deps = deps;
	}

	public QueryMessage(Set<MessageGid> deps, MultipartTimestamp prev, String op)
	{
		super(null);

		this.prev = prev;
		this.op = op;
		
		super.deps = deps;
	}

	public MultipartTimestamp getPrev()
	{
		return this.prev;
	}

	public String getOp()
	{
		return this.op;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString())
			.append("Prev: ").append(this.prev.toString()).append(";")
			.append("QMessageId: ").append(super.msg_id.toString());

		return sb.toString();
	}
}
