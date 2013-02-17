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

public class QuerySensorGeometricProperties extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x2805;
	
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
			
			public QuerySensorGeometricProperties.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x2805;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x2805;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public QuerySensorGeometricProperties.AppHeader.HeaderRec getHeaderRec()
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
		
		public QuerySensorGeometricProperties.AppHeader assign(AppHeader value)
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
		public static class  SensorIdList
		{
			public static class  SensorIdRec
			{
			
				protected SensorIdList m_parent;
				protected int m_SensorID;
			
				public void setParent(SensorIdList parent)
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
					
					bytes.putShort(pos, (short) m_SensorID);
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
					
					m_SensorID = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				
				public QuerySensorGeometricProperties.Body.SensorIdList.SensorIdRec assign(SensorIdRec value)
				{
					m_SensorID = value.m_SensorID;
					
					return this;
				}
				
				public boolean isEqual(SensorIdRec value)
				{
					if (m_SensorID != value.getSensorID())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(SensorIdRec value)
				{
					return !this.isEqual(value);
				}
				
				public SensorIdRec()
				{
					m_parent = null;
					m_SensorID = 0;
				}
				
				public SensorIdRec(SensorIdRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_SensorID = 0;
					
					/// Copy the values
					m_SensorID = value.m_SensorID;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<SensorIdRec> m_SensorIdRec;
		
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
				return (long) m_SensorIdRec.size();
			}
			
			public QuerySensorGeometricProperties.Body.SensorIdList.SensorIdRec getElement(int index)
			{
				return m_SensorIdRec.get(index);
			}
			
			public void setElement(int index, SensorIdRec value)
			{
				if(m_SensorIdRec.size()-1 < index)
				{
					return;
				}
				
				m_SensorIdRec.set(index, value);
				m_SensorIdRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(SensorIdRec value)
			{
				m_SensorIdRec.add(value);
				m_SensorIdRec.get(m_SensorIdRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_SensorIdRec.size()-1 < index)
				{
					return 1;
				}
				
				m_SensorIdRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_SensorIdRec.remove(m_SensorIdRec.size()-1);
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
				for (int i = 0; i < m_SensorIdRec.size(); i++)
				{
					size += m_SensorIdRec.get(i).getSize();
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
				
				int size = (int) m_SensorIdRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_SensorIdRec.size(); i++)
				{
					m_SensorIdRec.get(i).encode(bytes, pos);
					pos += m_SensorIdRec.get(i).getSize();
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
				m_SensorIdRec = new ArrayList<SensorIdRec>();
				for (int i = 0; i <  size; i++)
				{
					SensorIdRec item = new SensorIdRec();
					item.decode(bytes, pos);
					m_SensorIdRec.add(item);
					pos += item.getSize();
				}
			}
			
			public QuerySensorGeometricProperties.Body.SensorIdList assign(SensorIdList value)
			{
				m_SensorIdRec.clear();
				
				for (int i = 0; i < value.m_SensorIdRec.size(); i++)
				{
					m_SensorIdRec.add(value.m_SensorIdRec.get(i));
					m_SensorIdRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(SensorIdList value)
			{
				for (int i = 0; i < m_SensorIdRec.size(); i++)
				{
					if (!m_SensorIdRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(SensorIdList value)
			{
				return !this.isEqual(value);
			}
			
			public SensorIdList()
			{
				m_parent = null;
				m_SensorIdRec = new ArrayList<SensorIdRec>();
				for (int i = 0; i < m_SensorIdRec.size(); i++)
				{
					m_SensorIdRec.get(i).setParent(this);
				}
			}
			
			public SensorIdList(SensorIdList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_SensorIdRec = new ArrayList<SensorIdRec>();
				for (int i = 0; i < m_SensorIdRec.size(); i++)
				{
					m_SensorIdRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_SensorIdRec.clear();
				
				for (int i = 0; i < value.m_SensorIdRec.size(); i++)
				{
					m_SensorIdRec.add(value.m_SensorIdRec.get(i));
					m_SensorIdRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected SensorIdList m_SensorIdList;
	
		public QuerySensorGeometricProperties.Body.SensorIdList getSensorIdList()
		{
			return m_SensorIdList;
		}
		
		public void setSensorIdList(SensorIdList value)
		{
			m_SensorIdList = value;
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
			
			size += m_SensorIdList.getSize();
			
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
			
			m_SensorIdList.encode(bytes, pos);
			pos += m_SensorIdList.getSize();
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
			
			m_SensorIdList.decode(bytes, pos);
			pos += m_SensorIdList.getSize();
		}
		
		public QuerySensorGeometricProperties.Body assign(Body value)
		{
			m_SensorIdList = value.m_SensorIdList;
			m_SensorIdList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_SensorIdList.isEqual(value.m_SensorIdList))
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
			m_SensorIdList = new SensorIdList();
			m_SensorIdList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_SensorIdList = new SensorIdList();
			m_SensorIdList.setParent(this);
			
			/// Copy the values
			m_SensorIdList = value.m_SensorIdList;
			m_SensorIdList.setParent(this);
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
	public QuerySensorGeometricProperties.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public QuerySensorGeometricProperties.Body getBody()
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
	
	public QuerySensorGeometricProperties setAs(QuerySensorGeometricProperties value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(QuerySensorGeometricProperties value)
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
	
	public boolean notEquals(QuerySensorGeometricProperties value)
	{
		return !isEqual(value);
	}
	
	public QuerySensorGeometricProperties()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  QuerySensorGeometricProperties(QuerySensorGeometricProperties value)
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
