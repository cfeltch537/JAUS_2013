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

public class ReportAnalogVideoSensorConfiguration extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4811;
	
	public static class  AppHeader
	{
		public static class  HeaderRec
		{
		
			protected AppHeader m_parent;
			protected int m_MessageID;
		
			public void setParent(AppHeader parent)
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
			
			public ReportAnalogVideoSensorConfiguration.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4811;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4811;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportAnalogVideoSensorConfiguration.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportAnalogVideoSensorConfiguration.AppHeader assign(AppHeader value)
		{
			m_HeaderRec = value.m_HeaderRec;
			m_HeaderRec.setParent(this);
			
			return this;
		}
		
		public boolean isEqual(AppHeader value)
		{
			if (!m_HeaderRec.isEqual(value.getHeaderRec()))
			{
				return false;
			}
			return true;
		}
		
		public boolean notEquals(AppHeader value)
		{
			return !this.isEqual(value);
		}
		
		public AppHeader()
		{
			m_HeaderRec = new HeaderRec();
			m_HeaderRec.setParent(this);
		}
		
		public AppHeader(AppHeader value)
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
		public static class  AnalogVideoSensorConfigurationList
		{
			public static class  AnalogVideoSensorConfigurationRec
			{
			
				protected AnalogVideoSensorConfigurationList m_parent;
				protected int m_SensorID;
				protected short m_AnalogFormat;
			
				public void setParent(AnalogVideoSensorConfigurationList parent)
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
				
				public int getSensorID()
				{
					return m_SensorID;
				}
				
				public void setSensorID(int value)
				{
					m_SensorID = value;
					setParentPresenceVector();
				}
				
				public short getAnalogFormat()
				{
					return m_AnalogFormat;
				}
				
				public void setAnalogFormat(short value)
				{
					if ((value == 0) || (value == 1) || (value == 2) || (value == 3) || (value == 4) || (value == 5))
					{
						m_AnalogFormat = value;
						setParentPresenceVector();
					}
					return;
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
					
					bytes.putShort(pos, (short) m_SensorID);
					pos += JausUtils.getNumBytes("short");
					bytes.put(pos, (byte) m_AnalogFormat);
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
					
					m_SensorID = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
					m_AnalogFormat = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				
				public ReportAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationList.AnalogVideoSensorConfigurationRec assign(AnalogVideoSensorConfigurationRec value)
				{
					m_SensorID = value.m_SensorID;
					m_AnalogFormat = value.m_AnalogFormat;
					
					return this;
				}
				
				public boolean isEqual(AnalogVideoSensorConfigurationRec value)
				{
					if (m_SensorID != value.getSensorID())
					{
						return false;
					}
					if (m_AnalogFormat != value.getAnalogFormat())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(AnalogVideoSensorConfigurationRec value)
				{
					return !this.isEqual(value);
				}
				
				public AnalogVideoSensorConfigurationRec()
				{
					m_parent = null;
					m_SensorID = 0;
					m_AnalogFormat = 0;
				}
				
				public AnalogVideoSensorConfigurationRec(AnalogVideoSensorConfigurationRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_SensorID = 0;
					m_AnalogFormat = 0;
					
					/// Copy the values
					m_SensorID = value.m_SensorID;
					m_AnalogFormat = value.m_AnalogFormat;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<AnalogVideoSensorConfigurationRec> m_AnalogVideoSensorConfigurationRec;
		
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
				return (long) m_AnalogVideoSensorConfigurationRec.size();
			}
			
			public ReportAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationList.AnalogVideoSensorConfigurationRec getElement(int index)
			{
				return m_AnalogVideoSensorConfigurationRec.get(index);
			}
			
			public void setElement(int index, AnalogVideoSensorConfigurationRec value)
			{
				if(m_AnalogVideoSensorConfigurationRec.size()-1 < index)
				{
					return;
				}
				
				m_AnalogVideoSensorConfigurationRec.set(index, value);
				m_AnalogVideoSensorConfigurationRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(AnalogVideoSensorConfigurationRec value)
			{
				m_AnalogVideoSensorConfigurationRec.add(value);
				m_AnalogVideoSensorConfigurationRec.get(m_AnalogVideoSensorConfigurationRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_AnalogVideoSensorConfigurationRec.size()-1 < index)
				{
					return 1;
				}
				
				m_AnalogVideoSensorConfigurationRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_AnalogVideoSensorConfigurationRec.remove(m_AnalogVideoSensorConfigurationRec.size()-1);
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
				for (int i = 0; i < m_AnalogVideoSensorConfigurationRec.size(); i++)
				{
					size += m_AnalogVideoSensorConfigurationRec.get(i).getSize();
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
				
				int size = (int) m_AnalogVideoSensorConfigurationRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_AnalogVideoSensorConfigurationRec.size(); i++)
				{
					m_AnalogVideoSensorConfigurationRec.get(i).encode(bytes, pos);
					pos += m_AnalogVideoSensorConfigurationRec.get(i).getSize();
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
				m_AnalogVideoSensorConfigurationRec = new ArrayList<AnalogVideoSensorConfigurationRec>();
				for (int i = 0; i <  size; i++)
				{
					AnalogVideoSensorConfigurationRec item = new AnalogVideoSensorConfigurationRec();
					item.decode(bytes, pos);
					m_AnalogVideoSensorConfigurationRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationList assign(AnalogVideoSensorConfigurationList value)
			{
				m_AnalogVideoSensorConfigurationRec.clear();
				
				for (int i = 0; i < value.m_AnalogVideoSensorConfigurationRec.size(); i++)
				{
					m_AnalogVideoSensorConfigurationRec.add(value.m_AnalogVideoSensorConfigurationRec.get(i));
					m_AnalogVideoSensorConfigurationRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(AnalogVideoSensorConfigurationList value)
			{
				for (int i = 0; i < m_AnalogVideoSensorConfigurationRec.size(); i++)
				{
					if (!m_AnalogVideoSensorConfigurationRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(AnalogVideoSensorConfigurationList value)
			{
				return !this.isEqual(value);
			}
			
			public AnalogVideoSensorConfigurationList()
			{
				m_parent = null;
				m_AnalogVideoSensorConfigurationRec = new ArrayList<AnalogVideoSensorConfigurationRec>();
				for (int i = 0; i < m_AnalogVideoSensorConfigurationRec.size(); i++)
				{
					m_AnalogVideoSensorConfigurationRec.get(i).setParent(this);
				}
			}
			
			public AnalogVideoSensorConfigurationList(AnalogVideoSensorConfigurationList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_AnalogVideoSensorConfigurationRec = new ArrayList<AnalogVideoSensorConfigurationRec>();
				for (int i = 0; i < m_AnalogVideoSensorConfigurationRec.size(); i++)
				{
					m_AnalogVideoSensorConfigurationRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_AnalogVideoSensorConfigurationRec.clear();
				
				for (int i = 0; i < value.m_AnalogVideoSensorConfigurationRec.size(); i++)
				{
					m_AnalogVideoSensorConfigurationRec.add(value.m_AnalogVideoSensorConfigurationRec.get(i));
					m_AnalogVideoSensorConfigurationRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected AnalogVideoSensorConfigurationList m_AnalogVideoSensorConfigurationList;
	
		public ReportAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationList getAnalogVideoSensorConfigurationList()
		{
			return m_AnalogVideoSensorConfigurationList;
		}
		
		public void setAnalogVideoSensorConfigurationList(AnalogVideoSensorConfigurationList value)
		{
			m_AnalogVideoSensorConfigurationList = value;
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
			
			size += m_AnalogVideoSensorConfigurationList.getSize();
			
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
			
			m_AnalogVideoSensorConfigurationList.encode(bytes, pos);
			pos += m_AnalogVideoSensorConfigurationList.getSize();
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
			
			m_AnalogVideoSensorConfigurationList.decode(bytes, pos);
			pos += m_AnalogVideoSensorConfigurationList.getSize();
		}
		
		public ReportAnalogVideoSensorConfiguration.Body assign(Body value)
		{
			m_AnalogVideoSensorConfigurationList = value.m_AnalogVideoSensorConfigurationList;
			m_AnalogVideoSensorConfigurationList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_AnalogVideoSensorConfigurationList.isEqual(value.m_AnalogVideoSensorConfigurationList))
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
			m_AnalogVideoSensorConfigurationList = new AnalogVideoSensorConfigurationList();
			m_AnalogVideoSensorConfigurationList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_AnalogVideoSensorConfigurationList = new AnalogVideoSensorConfigurationList();
			m_AnalogVideoSensorConfigurationList.setParent(this);
			
			/// Copy the values
			m_AnalogVideoSensorConfigurationList = value.m_AnalogVideoSensorConfigurationList;
			m_AnalogVideoSensorConfigurationList.setParent(this);
			/// This code is currently not supported
		}
		
		public void finalize()
		{
		}
		
	}
	protected AppHeader m_AppHeader;
	protected Body m_Body;
	public long getID()
	{
	return ID;
 }
	public ReportAnalogVideoSensorConfiguration.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportAnalogVideoSensorConfiguration.Body getBody()
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
		
		size += m_AppHeader.getSize();
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
		
		m_AppHeader.encode(bytes, pos);
		pos += m_AppHeader.getSize();
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
		
		m_AppHeader.decode(bytes, pos);
		pos += m_AppHeader.getSize();
		m_Body.decode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public ReportAnalogVideoSensorConfiguration setAs(ReportAnalogVideoSensorConfiguration value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportAnalogVideoSensorConfiguration value)
	{
		if (!m_AppHeader.isEqual(value.getAppHeader()))
		{
			return false;
		}
		if (!m_Body.isEqual(value.getBody()))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean notEquals(ReportAnalogVideoSensorConfiguration value)
	{
		return !isEqual(value);
	}
	
	public ReportAnalogVideoSensorConfiguration()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportAnalogVideoSensorConfiguration(ReportAnalogVideoSensorConfiguration value)
	{
		/// Initiliaze the protected variables
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
		
		/// Copy the values
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
	}
	
}
