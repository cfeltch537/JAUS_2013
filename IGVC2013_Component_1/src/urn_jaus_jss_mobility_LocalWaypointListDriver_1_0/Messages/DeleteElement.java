package src.urn_jaus_jss_mobility_LocalWaypointListDriver_1_0.Messages;

import framework.messages.Message;
import framework.JausUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteElement extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x041b;
	
	public static class  MsgHeader
	{
		public static class  HeaderRec
		{
		
			protected MsgHeader m_parent;
			protected int m_MessageID;
		
			public void setParent(MsgHeader parent)
			{
				m_parent = parent;
			}
			
			public void setParentPresenceVector()
			{
				if(m_parent != null )
				{
					m_parent.setParentPresenceVector();
				}
			}
			
			public int getMessageID()
			{
				return m_MessageID;
			}
			
			public void setMessageID(int value)
			{
				m_MessageID = value;
				setParentPresenceVector();
			}
			
			/**
			 * Returns the number of bytes the used data members of the class occupies
			 * in the buffer. This is not the number of bytes the data type occupies in 
			 * Java, but the bytes expected on the wire.
			 * 
			 * @return
			 */
			public long getSize()
			{
				long size = 0;
				
				size += JausUtils.getNumBytes("short");
				
				return size;
			}
			
			public void encode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				bytes.putShort(pos, (short) m_MessageID);
				pos += JausUtils.getNumBytes("short");
			}
			
			public void decode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				m_MessageID = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
			}
			
			public DeleteElement.MsgHeader.HeaderRec assign(HeaderRec value)
			{
				m_MessageID = value.m_MessageID;
				
				return this;
			}
			
			public boolean isEqual(HeaderRec value)
			{
				if (m_MessageID != value.getMessageID())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(HeaderRec value)
			{
				return !this.isEqual(value);
			}
			
			public HeaderRec()
			{
				m_parent = null;
				m_MessageID = 0x041b;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x041b;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public DeleteElement.MsgHeader.HeaderRec getHeaderRec()
		{
			return m_HeaderRec;
		}
		
		public void setHeaderRec(HeaderRec value)
		{
			m_HeaderRec = value;
			setParentPresenceVector();
		}
		
		public void setParentPresenceVector()
		{
			// Nothing needed here, placeholder function
		}
		
		/**
		 * Returns the number of bytes the used data members of the class occupies
		 * in the buffer. This is not the number of bytes the data type occupies in 
		 * Java, but the bytes expected on the wire.
		 * 
		 * @return
		 */
		public long getSize()
		{
			long size = 0;
			
			size += m_HeaderRec.getSize();
			
			return size;
		}
		
		public void encode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_HeaderRec.encode(bytes, pos);
			pos += m_HeaderRec.getSize();
		}
		
		public void decode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_HeaderRec.decode(bytes, pos);
			pos += m_HeaderRec.getSize();
		}
		
		public DeleteElement.MsgHeader assign(MsgHeader value)
		{
			m_HeaderRec = value.m_HeaderRec;
			m_HeaderRec.setParent(this);
			
			return this;
		}
		
		public boolean isEqual(MsgHeader value)
		{
			if (!m_HeaderRec.isEqual(value.getHeaderRec()))
			{
				return false;
			}
			return true;
		}
		
		public boolean notEquals(MsgHeader value)
		{
			return !this.isEqual(value);
		}
		
		public MsgHeader()
		{
			m_HeaderRec = new HeaderRec();
			m_HeaderRec.setParent(this);
		}
		
		public MsgHeader(MsgHeader value)
		{
			/// Initiliaze the protected variables
			m_HeaderRec = new HeaderRec();
			m_HeaderRec.setParent(this);
			
			/// Copy the values
			m_HeaderRec = value.m_HeaderRec;
			m_HeaderRec.setParent(this);
		}
		
		public void finalize()
		{
		}
		
	}
	public static class  Body
	{
		public static class  DeleteElementSeq
		{
			public static class  RequestIDRec
			{
			
				protected DeleteElementSeq m_parent;
				protected short m_RequestID;
			
				public void setParent(DeleteElementSeq parent)
				{
					m_parent = parent;
				}
				
				public void setParentPresenceVector()
				{
					if(m_parent != null )
					{
						m_parent.setParentPresenceVector();
					}
				}
				
				public short getRequestID()
				{
					return m_RequestID;
				}
				
				public void setRequestID(short value)
				{
					m_RequestID = value;
					setParentPresenceVector();
				}
				
				/**
				 * Returns the number of bytes the used data members of the class occupies
				 * in the buffer. This is not the number of bytes the data type occupies in 
				 * Java, but the bytes expected on the wire.
				 * 
				 * @return
				 */
				public long getSize()
				{
					long size = 0;
					
					size += JausUtils.getNumBytes("byte");
					
					return size;
				}
				
				public void encode(ByteBuffer bytes, int pos)
				{
					
					if (bytes.array() == null)
					{
						return;
					}
					
					if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
					{
						bytes.order(ByteOrder.LITTLE_ENDIAN);
					}
					
					bytes.put(pos, (byte) m_RequestID);
					pos += JausUtils.getNumBytes("byte");
				}
				
				public void decode(ByteBuffer bytes, int pos)
				{
					
					if (bytes.array() == null)
					{
						return;
					}
					if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
					{
						bytes.order(ByteOrder.LITTLE_ENDIAN);
					}
					
					m_RequestID = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				
				public DeleteElement.Body.DeleteElementSeq.RequestIDRec assign(RequestIDRec value)
				{
					m_RequestID = value.m_RequestID;
					
					return this;
				}
				
				public boolean isEqual(RequestIDRec value)
				{
					if (m_RequestID != value.getRequestID())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(RequestIDRec value)
				{
					return !this.isEqual(value);
				}
				
				public RequestIDRec()
				{
					m_parent = null;
					m_RequestID = 0;
				}
				
				public RequestIDRec(RequestIDRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_RequestID = 0;
					
					/// Copy the values
					m_RequestID = value.m_RequestID;
				}
				
				public void finalize()
				{
				}
				
			}
			public static class  DeleteElementList
			{
				public static class  DeleteElementRec
				{
				
					protected DeleteElementList m_parent;
					protected int m_ElementUID;
				
					public void setParent(DeleteElementList parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setParentPresenceVector();
						}
					}
					
					public int getElementUID()
					{
						return m_ElementUID;
					}
					
					public void setElementUID(int value)
					{
						m_ElementUID = value;
						setParentPresenceVector();
					}
					
					/**
					 * Returns the number of bytes the used data members of the class occupies
					 * in the buffer. This is not the number of bytes the data type occupies in 
					 * Java, but the bytes expected on the wire.
					 * 
					 * @return
					 */
					public long getSize()
					{
						long size = 0;
						
						size += JausUtils.getNumBytes("short");
						
						return size;
					}
					
					public void encode(ByteBuffer bytes, int pos)
					{
						
						if (bytes.array() == null)
						{
							return;
						}
						
						if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
						{
							bytes.order(ByteOrder.LITTLE_ENDIAN);
						}
						
						bytes.putShort(pos, (short) m_ElementUID);
						pos += JausUtils.getNumBytes("short");
					}
					
					public void decode(ByteBuffer bytes, int pos)
					{
						
						if (bytes.array() == null)
						{
							return;
						}
						if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
						{
							bytes.order(ByteOrder.LITTLE_ENDIAN);
						}
						
						m_ElementUID = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					
					public DeleteElement.Body.DeleteElementSeq.DeleteElementList.DeleteElementRec assign(DeleteElementRec value)
					{
						m_ElementUID = value.m_ElementUID;
						
						return this;
					}
					
					public boolean isEqual(DeleteElementRec value)
					{
						if (m_ElementUID != value.getElementUID())
						{
							return false;
						}
						
						return true;
					}
					
					public boolean notEquals(DeleteElementRec value)
					{
						return !this.isEqual(value);
					}
					
					public DeleteElementRec()
					{
						m_parent = null;
						m_ElementUID = 0;
					}
					
					public DeleteElementRec(DeleteElementRec value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_ElementUID = 0;
						
						/// Copy the values
						m_ElementUID = value.m_ElementUID;
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected DeleteElementSeq m_parent;
				protected ArrayList<DeleteElementRec> m_DeleteElementRec;
			
				public void setParent(DeleteElementSeq parent)
				{
					m_parent = parent;
				}
				
				public void setParentPresenceVector()
				{
					if(m_parent != null )
					{
						m_parent.setParentPresenceVector();
					}
				}
				
				public long getNumberOfElements()
				{
					return (long) m_DeleteElementRec.size();
				}
				
				public DeleteElement.Body.DeleteElementSeq.DeleteElementList.DeleteElementRec getElement(int index)
				{
					return m_DeleteElementRec.get(index);
				}
				
				public void setElement(int index, DeleteElementRec value)
				{
					if(m_DeleteElementRec.size()-1 < index)
					{
						return;
					}
					
					m_DeleteElementRec.set(index, value);
					m_DeleteElementRec.get(index).setParent(this);
					setParentPresenceVector();
				}
				
				public void addElement(DeleteElementRec value)
				{
					m_DeleteElementRec.add(value);
					m_DeleteElementRec.get(m_DeleteElementRec.size() -1 ).setParent(this);
					setParentPresenceVector();
				}
				
				public int deleteElement(int index)
				{
					if(m_DeleteElementRec.size()-1 < index)
					{
						return 1;
					}
					
					m_DeleteElementRec.remove(index);
					return 0;
				}
				
				public int deleteLastElement()
				{
					m_DeleteElementRec.remove(m_DeleteElementRec.size()-1);
					return 0;
				}
				
				/**
				 * Returns the number of bytes the used data members of the class occupies
				 * in the buffer. This is not the number of bytes the data type occupies in 
				 * Java, but the bytes expected on the wire.
				 * 
				 * @return
				 */
				public long getSize()
				{
					long size = 0;
					
					size += JausUtils.getNumBytes("byte");
					for (int i = 0; i < m_DeleteElementRec.size(); i++)
					{
						size += m_DeleteElementRec.get(i).getSize();
					}
					
					return size;
				}
				
				public void encode(ByteBuffer bytes, int pos)
				{
					
					if (bytes.array() == null)
					{
						return;
					}
					
					if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
					{
						bytes.order(ByteOrder.LITTLE_ENDIAN);
					}
					
					short size = (short) m_DeleteElementRec.size();
					bytes.put(pos, (byte) size);
					pos += JausUtils.getNumBytes("byte");
					for (int i = 0; i < m_DeleteElementRec.size(); i++)
					{
						m_DeleteElementRec.get(i).encode(bytes, pos);
						pos += m_DeleteElementRec.get(i).getSize();
					}
				}
				
				public void decode(ByteBuffer bytes, int pos)
				{
					
					if (bytes.array() == null)
					{
						return;
					}
					if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
					{
						bytes.order(ByteOrder.LITTLE_ENDIAN);
					}
					
					short size;
					size = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
					m_DeleteElementRec = new ArrayList<DeleteElementRec>();
					for (int i = 0; i <  size; i++)
					{
						DeleteElementRec item = new DeleteElementRec();
						item.decode(bytes, pos);
						m_DeleteElementRec.add(item);
						pos += item.getSize();
					}
				}
				
				public DeleteElement.Body.DeleteElementSeq.DeleteElementList assign(DeleteElementList value)
				{
					m_DeleteElementRec.clear();
					
					for (int i = 0; i < value.m_DeleteElementRec.size(); i++)
					{
						m_DeleteElementRec.add(value.m_DeleteElementRec.get(i));
						m_DeleteElementRec.get(i).setParent(this);
					}
					
					return this;
				}
				
				public boolean isEqual(DeleteElementList value)
				{
					for (int i = 0; i < m_DeleteElementRec.size(); i++)
					{
						if (!m_DeleteElementRec.get(i).isEqual(value.getElement(i)))
						{
							return false;
						}
					}
					
					return true;
				}
				
				public boolean notEquals(DeleteElementList value)
				{
					return !this.isEqual(value);
				}
				
				public DeleteElementList()
				{
					m_parent = null;
					m_DeleteElementRec = new ArrayList<DeleteElementRec>();
					for (int i = 0; i < m_DeleteElementRec.size(); i++)
					{
						m_DeleteElementRec.get(i).setParent(this);
					}
				}
				
				public DeleteElementList(DeleteElementList value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_DeleteElementRec = new ArrayList<DeleteElementRec>();
					for (int i = 0; i < m_DeleteElementRec.size(); i++)
					{
						m_DeleteElementRec.get(i).setParent(this);
					}
					
					/// Copy the values
					m_DeleteElementRec.clear();
					
					for (int i = 0; i < value.m_DeleteElementRec.size(); i++)
					{
						m_DeleteElementRec.add(value.m_DeleteElementRec.get(i));
						m_DeleteElementRec.get(i).setParent(this);
					}
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected RequestIDRec m_RequestIDRec;
			protected DeleteElementList m_DeleteElementList;
		
			public void setParent(Body parent)
			{
				m_parent = parent;
			}
			
			public void setParentPresenceVector()
			{
				if(m_parent != null )
				{
					m_parent.setParentPresenceVector();
				}
			}
			
			public DeleteElement.Body.DeleteElementSeq.RequestIDRec getRequestIDRec()
			{
				return m_RequestIDRec;
			}
			
			public void setRequestIDRec(RequestIDRec value)
			{
				m_RequestIDRec = value;
				setParentPresenceVector();
			}
			
			public DeleteElement.Body.DeleteElementSeq.DeleteElementList getDeleteElementList()
			{
				return m_DeleteElementList;
			}
			
			public void setDeleteElementList(DeleteElementList value)
			{
				m_DeleteElementList = value;
				setParentPresenceVector();
			}
			
			/**
			 * Returns the number of bytes the used data members of the class occupies
			 * in the buffer. This is not the number of bytes the data type occupies in 
			 * Java, but the bytes expected on the wire.
			 * 
			 * @return
			 */
			public long getSize()
			{
				long size = 0;
				
				size += m_RequestIDRec.getSize();
				size += m_DeleteElementList.getSize();
				
				return size;
			}
			
			public void encode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				m_RequestIDRec.encode(bytes, pos);
				pos += m_RequestIDRec.getSize();
				m_DeleteElementList.encode(bytes, pos);
				pos += m_DeleteElementList.getSize();
			}
			
			public void decode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				m_RequestIDRec.decode(bytes, pos);
				pos += m_RequestIDRec.getSize();
				m_DeleteElementList.decode(bytes, pos);
				pos += m_DeleteElementList.getSize();
			}
			
			public DeleteElement.Body.DeleteElementSeq assign(DeleteElementSeq value)
			{
				m_RequestIDRec = value.m_RequestIDRec;
				m_RequestIDRec.setParent(this);
				m_RequestIDRec = value.m_RequestIDRec;
				m_DeleteElementList = value.m_DeleteElementList;
				m_DeleteElementList.setParent(this);
				m_DeleteElementList = value.m_DeleteElementList;
				
				return this;
			}
			
			public boolean isEqual(DeleteElementSeq value)
			{
				if (!m_RequestIDRec.isEqual(value.getRequestIDRec()))
				{
					return false;
				}
				
				if (!m_RequestIDRec.isEqual(value.getRequestIDRec()))
				{
					return false;
				}
				if (!m_DeleteElementList.isEqual(value.m_DeleteElementList))
				{
					return false;
				}
				
				if (!m_DeleteElementList.isEqual(value.getDeleteElementList()))
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(DeleteElementSeq value)
			{
				return !this.isEqual(value);
			}
			
			public DeleteElementSeq()
			{
				m_parent = null;
				m_RequestIDRec = new RequestIDRec();
				m_RequestIDRec.setParent(this);
				m_DeleteElementList = new DeleteElementList();
				m_DeleteElementList.setParent(this);
			}
			
			public DeleteElementSeq(DeleteElementSeq value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_RequestIDRec = new RequestIDRec();
				m_RequestIDRec.setParent(this);
				m_DeleteElementList = new DeleteElementList();
				m_DeleteElementList.setParent(this);
				
				/// Copy the values
				m_RequestIDRec = value.m_RequestIDRec;
				m_RequestIDRec.setParent(this);
				m_RequestIDRec = value.m_RequestIDRec;
				m_DeleteElementList = value.m_DeleteElementList;
				m_DeleteElementList.setParent(this);
				m_DeleteElementList = value.m_DeleteElementList;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected DeleteElementSeq m_DeleteElementSeq;
	
		public DeleteElement.Body.DeleteElementSeq getDeleteElementSeq()
		{
			return m_DeleteElementSeq;
		}
		
		public int setDeleteElementSeq(DeleteElementSeq value)
		{
			m_DeleteElementSeq = value;
			setParentPresenceVector();
			return 0;
		}
		
		public void setParentPresenceVector()
		{
			// Nothing needed here, placeholder function
		}
		
		/**
		 * Returns the number of bytes the used data members of the class occupies
		 * in the buffer. This is not the number of bytes the data type occupies in 
		 * Java, but the bytes expected on the wire.
		 * 
		 * @return
		 */
		public long getSize()
		{
			long size = 0;
			
			size += m_DeleteElementSeq.getSize();
			
			return size;
		}
		
		public void encode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_DeleteElementSeq.encode(bytes, pos);
			pos += m_DeleteElementSeq.getSize();
		}
		
		public void decode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_DeleteElementSeq.decode(bytes, pos);
			pos += m_DeleteElementSeq.getSize();
		}
		
		public DeleteElement.Body assign(Body value)
		{
			m_DeleteElementSeq = value.m_DeleteElementSeq;
			m_DeleteElementSeq.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_DeleteElementSeq.isEqual(value.getDeleteElementSeq()))
			{
				return false;
			}
			/// This code is currently not supported
			return true;
		}
		
		public boolean notEquals(Body value)
		{
			return !this.isEqual(value);
		}
		
		public Body()
		{
			m_DeleteElementSeq = new DeleteElementSeq();
			m_DeleteElementSeq.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_DeleteElementSeq = new DeleteElementSeq();
			m_DeleteElementSeq.setParent(this);
			
			/// Copy the values
			m_DeleteElementSeq = value.m_DeleteElementSeq;
			m_DeleteElementSeq.setParent(this);
			/// This code is currently not supported
		}
		
		public void finalize()
		{
		}
		
	}
	protected MsgHeader m_MsgHeader;
	protected Body m_Body;
	public long getID()
	{
	return ID;
 }
	public DeleteElement.MsgHeader getMsgHeader()
	{
		return m_MsgHeader;
	}
	
	public void setMsgHeader(MsgHeader value)
	{
		m_MsgHeader = value;
	}
	
	public DeleteElement.Body getBody()
	{
		return m_Body;
	}
	
	public int setBody(Body value)
	{
		m_Body = value;
		return 0;
	}
	
	/**
	 * Returns the number of bytes the used data members of the class occupies
	 * in the buffer. This is not the number of bytes the data type occupies in 
	 * Java, but the bytes expected on the wire.
	 * 
	 * @return
	 */
	public long getSize()
	{
		int size = 0;
		
		size += m_MsgHeader.getSize();
		size += m_Body.getSize();
		
		return size;
	}
	
	public void encode(ByteBuffer bytes, int pos)
	{
		
		if (bytes.array() == null)
		{
			return;
		}
		if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
		{
			bytes.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		m_MsgHeader.encode(bytes, pos);
		pos += m_MsgHeader.getSize();
		m_Body.encode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public void decode(ByteBuffer bytes, int pos)
	{
		
		if (bytes.array() == null)
		{
			return;
		}
		if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
		{
			bytes.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		m_MsgHeader.decode(bytes, pos);
		pos += m_MsgHeader.getSize();
		m_Body.decode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public DeleteElement setAs(DeleteElement value)
	{
		m_MsgHeader = value.m_MsgHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(DeleteElement value)
	{
		if (!m_MsgHeader.isEqual(value.getMsgHeader()))
		{
			return false;
		}
		if (!m_Body.isEqual(value.getBody()))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean notEquals(DeleteElement value)
	{
		return !isEqual(value);
	}
	
	public DeleteElement()
	{
		m_MsgHeader = new MsgHeader();
		m_Body = new Body();
		m_IsCommand = true;
	}
	
	public  DeleteElement(DeleteElement value)
	{
		/// Initiliaze the protected variables
		m_MsgHeader = new MsgHeader();
		m_Body = new Body();
		m_IsCommand = true;
		
		/// Copy the values
		m_MsgHeader = value.m_MsgHeader;
		m_Body = value.m_Body;
	}
	
}
