package src.urn_TestCOPServiceDef_1_0.Messages;

import framework.messages.Message;
import framework.JausUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportSubsystemList extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4b02;
	
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
			
			public ReportSubsystemList.MsgHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4b02;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4b02;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportSubsystemList.MsgHeader.HeaderRec getHeaderRec()
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
		
		public ReportSubsystemList.MsgHeader assign(MsgHeader value)
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
		public static class  SubsystemList
		{
			public static class  SubsystemRec
			{
			
				protected SubsystemList m_parent;
				protected int m_SubsystemID;
				protected short m_NodeID;
				protected short m_ComponentID;
			
				public void setParent(SubsystemList parent)
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
				
				public int getSubsystemID()
				{
					return m_SubsystemID;
				}
				
				public void setSubsystemID(int value)
				{
					m_SubsystemID = value;
					setParentPresenceVector();
				}
				
				public short getNodeID()
				{
					return m_NodeID;
				}
				
				public void setNodeID(short value)
				{
					m_NodeID = value;
					setParentPresenceVector();
				}
				
				public short getComponentID()
				{
					return m_ComponentID;
				}
				
				public void setComponentID(short value)
				{
					m_ComponentID = value;
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
					size += JausUtils.getNumBytes("byte");
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
					
					bytes.putShort(pos, (short) m_SubsystemID);
					pos += JausUtils.getNumBytes("short");
					bytes.put(pos, (byte) m_NodeID);
					pos += JausUtils.getNumBytes("byte");
					bytes.put(pos, (byte) m_ComponentID);
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
					
					m_SubsystemID = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
					m_NodeID = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
					m_ComponentID = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				
				public ReportSubsystemList.Body.SubsystemList.SubsystemRec assign(SubsystemRec value)
				{
					m_SubsystemID = value.m_SubsystemID;
					m_NodeID = value.m_NodeID;
					m_ComponentID = value.m_ComponentID;
					
					return this;
				}
				
				public boolean isEqual(SubsystemRec value)
				{
					if (m_SubsystemID != value.getSubsystemID())
					{
						return false;
					}
					if (m_NodeID != value.getNodeID())
					{
						return false;
					}
					if (m_ComponentID != value.getComponentID())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(SubsystemRec value)
				{
					return !this.isEqual(value);
				}
				
				public SubsystemRec()
				{
					m_parent = null;
					m_SubsystemID = 0;
					m_NodeID = 0;
					m_ComponentID = 0;
				}
				
				public SubsystemRec(SubsystemRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_SubsystemID = 0;
					m_NodeID = 0;
					m_ComponentID = 0;
					
					/// Copy the values
					m_SubsystemID = value.m_SubsystemID;
					m_NodeID = value.m_NodeID;
					m_ComponentID = value.m_ComponentID;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<SubsystemRec> m_SubsystemRec;
		
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
			
			public long getNumberOfElements()
			{
				return (long) m_SubsystemRec.size();
			}
			
			public ReportSubsystemList.Body.SubsystemList.SubsystemRec getElement(int index)
			{
				return m_SubsystemRec.get(index);
			}
			
			public void setElement(int index, SubsystemRec value)
			{
				if(m_SubsystemRec.size()-1 < index)
				{
					return;
				}
				
				m_SubsystemRec.set(index, value);
				m_SubsystemRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(SubsystemRec value)
			{
				m_SubsystemRec.add(value);
				m_SubsystemRec.get(m_SubsystemRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_SubsystemRec.size()-1 < index)
				{
					return 1;
				}
				
				m_SubsystemRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_SubsystemRec.remove(m_SubsystemRec.size()-1);
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
				for (int i = 0; i < m_SubsystemRec.size(); i++)
				{
					size += m_SubsystemRec.get(i).getSize();
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
				
				short size = (short) m_SubsystemRec.size();
				bytes.put(pos, (byte) size);
				pos += JausUtils.getNumBytes("byte");
				for (int i = 0; i < m_SubsystemRec.size(); i++)
				{
					m_SubsystemRec.get(i).encode(bytes, pos);
					pos += m_SubsystemRec.get(i).getSize();
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
				m_SubsystemRec = new ArrayList<SubsystemRec>();
				for (int i = 0; i <  size; i++)
				{
					SubsystemRec item = new SubsystemRec();
					item.decode(bytes, pos);
					m_SubsystemRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportSubsystemList.Body.SubsystemList assign(SubsystemList value)
			{
				m_SubsystemRec.clear();
				
				for (int i = 0; i < value.m_SubsystemRec.size(); i++)
				{
					m_SubsystemRec.add(value.m_SubsystemRec.get(i));
					m_SubsystemRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(SubsystemList value)
			{
				for (int i = 0; i < m_SubsystemRec.size(); i++)
				{
					if (!m_SubsystemRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(SubsystemList value)
			{
				return !this.isEqual(value);
			}
			
			public SubsystemList()
			{
				m_parent = null;
				m_SubsystemRec = new ArrayList<SubsystemRec>();
				for (int i = 0; i < m_SubsystemRec.size(); i++)
				{
					m_SubsystemRec.get(i).setParent(this);
				}
			}
			
			public SubsystemList(SubsystemList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_SubsystemRec = new ArrayList<SubsystemRec>();
				for (int i = 0; i < m_SubsystemRec.size(); i++)
				{
					m_SubsystemRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_SubsystemRec.clear();
				
				for (int i = 0; i < value.m_SubsystemRec.size(); i++)
				{
					m_SubsystemRec.add(value.m_SubsystemRec.get(i));
					m_SubsystemRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected SubsystemList m_SubsystemList;
	
		public ReportSubsystemList.Body.SubsystemList getSubsystemList()
		{
			return m_SubsystemList;
		}
		
		public void setSubsystemList(SubsystemList value)
		{
			m_SubsystemList = value;
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
			
			size += m_SubsystemList.getSize();
			
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
			
			m_SubsystemList.encode(bytes, pos);
			pos += m_SubsystemList.getSize();
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
			
			m_SubsystemList.decode(bytes, pos);
			pos += m_SubsystemList.getSize();
		}
		
		public ReportSubsystemList.Body assign(Body value)
		{
			m_SubsystemList = value.m_SubsystemList;
			m_SubsystemList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_SubsystemList.isEqual(value.m_SubsystemList))
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
			m_SubsystemList = new SubsystemList();
			m_SubsystemList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_SubsystemList = new SubsystemList();
			m_SubsystemList.setParent(this);
			
			/// Copy the values
			m_SubsystemList = value.m_SubsystemList;
			m_SubsystemList.setParent(this);
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
	public ReportSubsystemList.MsgHeader getMsgHeader()
	{
		return m_MsgHeader;
	}
	
	public void setMsgHeader(MsgHeader value)
	{
		m_MsgHeader = value;
	}
	
	public ReportSubsystemList.Body getBody()
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
	
	public ReportSubsystemList setAs(ReportSubsystemList value)
	{
		m_MsgHeader = value.m_MsgHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportSubsystemList value)
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
	
	public boolean notEquals(ReportSubsystemList value)
	{
		return !isEqual(value);
	}
	
	public ReportSubsystemList()
	{
		m_MsgHeader = new MsgHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportSubsystemList(ReportSubsystemList value)
	{
		/// Initiliaze the protected variables
		m_MsgHeader = new MsgHeader();
		m_Body = new Body();
		m_IsCommand = false;
		
		/// Copy the values
		m_MsgHeader = value.m_MsgHeader;
		m_Body = value.m_Body;
	}
	
}
