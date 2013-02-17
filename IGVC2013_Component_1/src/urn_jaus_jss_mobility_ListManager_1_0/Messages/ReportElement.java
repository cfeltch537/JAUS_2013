package src.urn_jaus_jss_mobility_ListManager_1_0.Messages;

import framework.messages.Message;
import framework.JausUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportElement extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x441a;
	
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
			
			public ReportElement.MsgHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x441a;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x441a;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportElement.MsgHeader.HeaderRec getHeaderRec()
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
		
		public ReportElement.MsgHeader assign(MsgHeader value)
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
		public static class  ElementRec
		{
			public static class  ElementData
			{
			
				protected ElementRec m_parent;
				protected short m_Format;
				protected int m_Length;
				protected ByteBuffer m_Data;
			
				public void setParent(ElementRec parent)
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
				
				public short getFormat()
				{
					return m_Format;
				}
				
				public int getLength()
				{
					return m_Length;
				}
				
				public ByteBuffer getData()
				{
					m_Data.rewind();
					ByteBuffer ret = ByteBuffer.allocate(m_Data.array().length);
					ret.order(ByteOrder.LITTLE_ENDIAN);
					ret.put(m_Data);
					return ret;
				}
				
				public void set(short format, int length, ByteBuffer data)
				{
					if ((format == 0)||(format == 1))
					{
						m_Format = format;
						m_Length = length;
					
						m_Data.clear();
					
						data.rewind();
						m_Data = ByteBuffer.allocate(data.array().length);
						m_Data.order(ByteOrder.LITTLE_ENDIAN);
						m_Data.put(data);
					
					setParentPresenceVector();
					
						return;
					}
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
					size += JausUtils.getNumBytes("short");
					size += m_Length;
					
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
					
					bytes.put(pos, (byte) m_Format);
					pos += JausUtils.getNumBytes("byte");
					
					bytes.putShort(pos, (short) m_Length);
					pos += JausUtils.getNumBytes("short");
					
					byte[] dataBytes = m_Data.array();
					
					for(int i = 0; i<(int) m_Length; i++)
					{
						bytes.put(pos, dataBytes[i]);
						pos++;
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
					
					m_Format = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
					
					m_Length = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
					
					byte[] dataBytes = new byte[(int)m_Length];
					
					int i;
					for(i=0; i<(int)m_Length; i++)
					{
						dataBytes[i] = bytes.get(pos);
						pos++;
					}
					
					m_Data = ByteBuffer.allocate((int)m_Length).order(ByteOrder.LITTLE_ENDIAN);
					m_Data.put(dataBytes);
				}
				
				public ReportElement.Body.ElementRec.ElementData assign(ElementData value)
				{
					this.m_Format = value.m_Format;
					this.m_Length = value.m_Length;
					
					m_Data.clear();
					
					if (m_Length > 0)
					{
					this.m_Data = ByteBuffer.wrap(value.m_Data.array()).order(ByteOrder.LITTLE_ENDIAN);
					}
					
					return this;
				}
				
				public boolean isEqual(ElementData value)
				{
					if (this.m_Format != value.m_Format)
					{
						return false;
					}
					
					if (this.m_Length != value.m_Length)
					{
						return false;
					}
					
					if ((this.m_Data.array() != null) && (value.m_Data.array() != null))
					{
						if(!Arrays.equals(this.m_Data.array(), value.m_Data.array()))
						{
							return false;
						}
					}
					// This case should never be true since it should not be possible
					// for the two variables to have equal lengths but one has no data.
					// This check is placed here as a secondary check.
					else if ((this.m_Data.array() != null) || (value.m_Data.array() != null))
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(ElementData value)
				{
					return !this.isEqual(value);
				}
				
				public ElementData()
				{
					m_parent = null;
					m_Length = MAX_JTS_MESSAGE_SIZE;
					m_Data = ByteBuffer.allocate((int)m_Length);
					m_Data.order(ByteOrder.LITTLE_ENDIAN);
					m_Format = 0;
				}
				
				public ElementData(ElementData value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_Length = MAX_JTS_MESSAGE_SIZE;
					m_Data = ByteBuffer.allocate((int)m_Length);
					m_Data.order(ByteOrder.LITTLE_ENDIAN);
					m_Format = 0;
					
					/// Copy the values
					this.m_Format = value.m_Format;
					this.m_Length = value.m_Length;
					
					m_Data.clear();
					
					if (m_Length > 0)
					{
					this.m_Data = ByteBuffer.wrap(value.m_Data.array()).order(ByteOrder.LITTLE_ENDIAN);
					}
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected int m_ElementUID;
			protected int m_PreviousUID;
			protected int m_NextUID;
			protected ElementData m_ElementData;
		
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
			
			public int getElementUID()
			{
				return m_ElementUID;
			}
			
			public void setElementUID(int value)
			{
				m_ElementUID = value;
				setParentPresenceVector();
			}
			
			public int getPreviousUID()
			{
				return m_PreviousUID;
			}
			
			public void setPreviousUID(int value)
			{
				m_PreviousUID = value;
				setParentPresenceVector();
			}
			
			public int getNextUID()
			{
				return m_NextUID;
			}
			
			public void setNextUID(int value)
			{
				m_NextUID = value;
				setParentPresenceVector();
			}
			
			public ReportElement.Body.ElementRec.ElementData getElementData()
			{
				return m_ElementData;
			}
			
			public int setElementData(ElementData value)
			{
				m_ElementData = value;
				setParentPresenceVector();
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
				size += JausUtils.getNumBytes("short");
				size += JausUtils.getNumBytes("short");
				size += m_ElementData.getSize();
				
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
				bytes.putShort(pos, (short) m_PreviousUID);
				pos += JausUtils.getNumBytes("short");
				bytes.putShort(pos, (short) m_NextUID);
				pos += JausUtils.getNumBytes("short");
				m_ElementData.encode(bytes, pos);
				pos += m_ElementData.getSize();
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
				m_PreviousUID = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
				m_NextUID = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
				m_ElementData.decode(bytes, pos);
				pos += m_ElementData.getSize();
			}
			
			public ReportElement.Body.ElementRec assign(ElementRec value)
			{
				m_ElementUID = value.m_ElementUID;
				m_PreviousUID = value.m_PreviousUID;
				m_NextUID = value.m_NextUID;
				m_ElementData = value.m_ElementData;
				
				return this;
			}
			
			public boolean isEqual(ElementRec value)
			{
				if (m_ElementUID != value.getElementUID())
				{
					return false;
				}
				if (m_PreviousUID != value.getPreviousUID())
				{
					return false;
				}
				if (m_NextUID != value.getNextUID())
				{
					return false;
				}
				
				if (!m_ElementData.isEqual(value.getElementData()))
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(ElementRec value)
			{
				return !this.isEqual(value);
			}
			
			public ElementRec()
			{
				m_parent = null;
				m_ElementUID = 0;
				m_PreviousUID = 0;
				m_NextUID = 0;
				m_ElementData = new ElementData();
				m_ElementData.setParent(this);
			}
			
			public ElementRec(ElementRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_ElementUID = 0;
				m_PreviousUID = 0;
				m_NextUID = 0;
				m_ElementData = new ElementData();
				m_ElementData.setParent(this);
				
				/// Copy the values
				m_ElementUID = value.m_ElementUID;
				m_PreviousUID = value.m_PreviousUID;
				m_NextUID = value.m_NextUID;
				m_ElementData = value.m_ElementData;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected ElementRec m_ElementRec;
	
		public ReportElement.Body.ElementRec getElementRec()
		{
			return m_ElementRec;
		}
		
		public void setElementRec(ElementRec value)
		{
			m_ElementRec = value;
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
			
			size += m_ElementRec.getSize();
			
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
			
			m_ElementRec.encode(bytes, pos);
			pos += m_ElementRec.getSize();
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
			
			m_ElementRec.decode(bytes, pos);
			pos += m_ElementRec.getSize();
		}
		
		public ReportElement.Body assign(Body value)
		{
			m_ElementRec = value.m_ElementRec;
			m_ElementRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_ElementRec.isEqual(value.getElementRec()))
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
			m_ElementRec = new ElementRec();
			m_ElementRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_ElementRec = new ElementRec();
			m_ElementRec.setParent(this);
			
			/// Copy the values
			m_ElementRec = value.m_ElementRec;
			m_ElementRec.setParent(this);
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
	public ReportElement.MsgHeader getMsgHeader()
	{
		return m_MsgHeader;
	}
	
	public void setMsgHeader(MsgHeader value)
	{
		m_MsgHeader = value;
	}
	
	public ReportElement.Body getBody()
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
	
	public ReportElement setAs(ReportElement value)
	{
		m_MsgHeader = value.m_MsgHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportElement value)
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
	
	public boolean notEquals(ReportElement value)
	{
		return !isEqual(value);
	}
	
	public ReportElement()
	{
		m_MsgHeader = new MsgHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportElement(ReportElement value)
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
