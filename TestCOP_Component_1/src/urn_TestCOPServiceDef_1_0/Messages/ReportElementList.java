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

public class ReportElementList extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x441b;
	
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
			
			public ReportElementList.MsgHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x441b;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x441b;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportElementList.MsgHeader.HeaderRec getHeaderRec()
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
		
		public ReportElementList.MsgHeader assign(MsgHeader value)
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
		public static class  ElementList
		{
			public static class  ElementListRec
			{
			
				protected ElementList m_parent;
				protected int m_ElementUID;
			
				public void setParent(ElementList parent)
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
				
				public ReportElementList.Body.ElementList.ElementListRec assign(ElementListRec value)
				{
					m_ElementUID = value.m_ElementUID;
					
					return this;
				}
				
				public boolean isEqual(ElementListRec value)
				{
					if (m_ElementUID != value.getElementUID())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(ElementListRec value)
				{
					return !this.isEqual(value);
				}
				
				public ElementListRec()
				{
					m_parent = null;
					m_ElementUID = 0;
				}
				
				public ElementListRec(ElementListRec value)
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
		
		
			protected Body m_parent;
			protected ArrayList<ElementListRec> m_ElementListRec;
		
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
				return (long) m_ElementListRec.size();
			}
			
			public ReportElementList.Body.ElementList.ElementListRec getElement(int index)
			{
				return m_ElementListRec.get(index);
			}
			
			public void setElement(int index, ElementListRec value)
			{
				if(m_ElementListRec.size()-1 < index)
				{
					return;
				}
				
				m_ElementListRec.set(index, value);
				m_ElementListRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(ElementListRec value)
			{
				m_ElementListRec.add(value);
				m_ElementListRec.get(m_ElementListRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_ElementListRec.size()-1 < index)
				{
					return 1;
				}
				
				m_ElementListRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_ElementListRec.remove(m_ElementListRec.size()-1);
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
				
				size += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_ElementListRec.size(); i++)
				{
					size += m_ElementListRec.get(i).getSize();
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
				
				int size = (int) m_ElementListRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_ElementListRec.size(); i++)
				{
					m_ElementListRec.get(i).encode(bytes, pos);
					pos += m_ElementListRec.get(i).getSize();
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
				
				int size;
				size = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
				m_ElementListRec = new ArrayList<ElementListRec>();
				for (int i = 0; i <  size; i++)
				{
					ElementListRec item = new ElementListRec();
					item.decode(bytes, pos);
					m_ElementListRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportElementList.Body.ElementList assign(ElementList value)
			{
				m_ElementListRec.clear();
				
				for (int i = 0; i < value.m_ElementListRec.size(); i++)
				{
					m_ElementListRec.add(value.m_ElementListRec.get(i));
					m_ElementListRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(ElementList value)
			{
				for (int i = 0; i < m_ElementListRec.size(); i++)
				{
					if (!m_ElementListRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(ElementList value)
			{
				return !this.isEqual(value);
			}
			
			public ElementList()
			{
				m_parent = null;
				m_ElementListRec = new ArrayList<ElementListRec>();
				for (int i = 0; i < m_ElementListRec.size(); i++)
				{
					m_ElementListRec.get(i).setParent(this);
				}
			}
			
			public ElementList(ElementList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_ElementListRec = new ArrayList<ElementListRec>();
				for (int i = 0; i < m_ElementListRec.size(); i++)
				{
					m_ElementListRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_ElementListRec.clear();
				
				for (int i = 0; i < value.m_ElementListRec.size(); i++)
				{
					m_ElementListRec.add(value.m_ElementListRec.get(i));
					m_ElementListRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected ElementList m_ElementList;
	
		public ReportElementList.Body.ElementList getElementList()
		{
			return m_ElementList;
		}
		
		public void setElementList(ElementList value)
		{
			m_ElementList = value;
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
			
			size += m_ElementList.getSize();
			
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
			
			m_ElementList.encode(bytes, pos);
			pos += m_ElementList.getSize();
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
			
			m_ElementList.decode(bytes, pos);
			pos += m_ElementList.getSize();
		}
		
		public ReportElementList.Body assign(Body value)
		{
			m_ElementList = value.m_ElementList;
			m_ElementList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_ElementList.isEqual(value.m_ElementList))
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
			m_ElementList = new ElementList();
			m_ElementList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_ElementList = new ElementList();
			m_ElementList.setParent(this);
			
			/// Copy the values
			m_ElementList = value.m_ElementList;
			m_ElementList.setParent(this);
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
	public ReportElementList.MsgHeader getMsgHeader()
	{
		return m_MsgHeader;
	}
	
	public void setMsgHeader(MsgHeader value)
	{
		m_MsgHeader = value;
	}
	
	public ReportElementList.Body getBody()
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
	
	public ReportElementList setAs(ReportElementList value)
	{
		m_MsgHeader = value.m_MsgHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportElementList value)
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
	
	public boolean notEquals(ReportElementList value)
	{
		return !isEqual(value);
	}
	
	public ReportElementList()
	{
		m_MsgHeader = new MsgHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportElementList(ReportElementList value)
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
