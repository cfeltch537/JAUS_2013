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

public class QueryRangeSensorConfiguration extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x2802;
	
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
			
			public QueryRangeSensorConfiguration.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x2802;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x2802;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public QueryRangeSensorConfiguration.AppHeader.HeaderRec getHeaderRec()
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
		
		public QueryRangeSensorConfiguration.AppHeader assign(AppHeader value)
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
		public static class  RangeSensorConfigurationList
		{
			public static class  QueryRangeSensorConfigurationRec
			{
			
				protected RangeSensorConfigurationList m_parent;
				protected int m_SensorID;
				protected int m_QueryPresenceVector;
			
				public void setParent(RangeSensorConfigurationList parent)
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
				
				public int getQueryPresenceVector()
				{
					return m_QueryPresenceVector;
				}
				
				public void setQueryPresenceVector(int value)
				{
					m_QueryPresenceVector = value;
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
					bytes.putShort(pos, (short) m_QueryPresenceVector);
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
					m_QueryPresenceVector = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				
				public QueryRangeSensorConfiguration.Body.RangeSensorConfigurationList.QueryRangeSensorConfigurationRec assign(QueryRangeSensorConfigurationRec value)
				{
					m_SensorID = value.m_SensorID;
					m_QueryPresenceVector = value.m_QueryPresenceVector;
					
					return this;
				}
				
				public boolean isEqual(QueryRangeSensorConfigurationRec value)
				{
					if (m_SensorID != value.getSensorID())
					{
						return false;
					}
					if (m_QueryPresenceVector != value.getQueryPresenceVector())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(QueryRangeSensorConfigurationRec value)
				{
					return !this.isEqual(value);
				}
				
				public QueryRangeSensorConfigurationRec()
				{
					m_parent = null;
					m_SensorID = 0;
					m_QueryPresenceVector = 0;
				}
				
				public QueryRangeSensorConfigurationRec(QueryRangeSensorConfigurationRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_SensorID = 0;
					m_QueryPresenceVector = 0;
					
					/// Copy the values
					m_SensorID = value.m_SensorID;
					m_QueryPresenceVector = value.m_QueryPresenceVector;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<QueryRangeSensorConfigurationRec> m_QueryRangeSensorConfigurationRec;
		
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
				return (long) m_QueryRangeSensorConfigurationRec.size();
			}
			
			public QueryRangeSensorConfiguration.Body.RangeSensorConfigurationList.QueryRangeSensorConfigurationRec getElement(int index)
			{
				return m_QueryRangeSensorConfigurationRec.get(index);
			}
			
			public void setElement(int index, QueryRangeSensorConfigurationRec value)
			{
				if(m_QueryRangeSensorConfigurationRec.size()-1 < index)
				{
					return;
				}
				
				m_QueryRangeSensorConfigurationRec.set(index, value);
				m_QueryRangeSensorConfigurationRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(QueryRangeSensorConfigurationRec value)
			{
				m_QueryRangeSensorConfigurationRec.add(value);
				m_QueryRangeSensorConfigurationRec.get(m_QueryRangeSensorConfigurationRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_QueryRangeSensorConfigurationRec.size()-1 < index)
				{
					return 1;
				}
				
				m_QueryRangeSensorConfigurationRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_QueryRangeSensorConfigurationRec.remove(m_QueryRangeSensorConfigurationRec.size()-1);
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
				for (int i = 0; i < m_QueryRangeSensorConfigurationRec.size(); i++)
				{
					size += m_QueryRangeSensorConfigurationRec.get(i).getSize();
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
				
				int size = (int) m_QueryRangeSensorConfigurationRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_QueryRangeSensorConfigurationRec.size(); i++)
				{
					m_QueryRangeSensorConfigurationRec.get(i).encode(bytes, pos);
					pos += m_QueryRangeSensorConfigurationRec.get(i).getSize();
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
				m_QueryRangeSensorConfigurationRec = new ArrayList<QueryRangeSensorConfigurationRec>();
				for (int i = 0; i <  size; i++)
				{
					QueryRangeSensorConfigurationRec item = new QueryRangeSensorConfigurationRec();
					item.decode(bytes, pos);
					m_QueryRangeSensorConfigurationRec.add(item);
					pos += item.getSize();
				}
			}
			
			public QueryRangeSensorConfiguration.Body.RangeSensorConfigurationList assign(RangeSensorConfigurationList value)
			{
				m_QueryRangeSensorConfigurationRec.clear();
				
				for (int i = 0; i < value.m_QueryRangeSensorConfigurationRec.size(); i++)
				{
					m_QueryRangeSensorConfigurationRec.add(value.m_QueryRangeSensorConfigurationRec.get(i));
					m_QueryRangeSensorConfigurationRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(RangeSensorConfigurationList value)
			{
				for (int i = 0; i < m_QueryRangeSensorConfigurationRec.size(); i++)
				{
					if (!m_QueryRangeSensorConfigurationRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(RangeSensorConfigurationList value)
			{
				return !this.isEqual(value);
			}
			
			public RangeSensorConfigurationList()
			{
				m_parent = null;
				m_QueryRangeSensorConfigurationRec = new ArrayList<QueryRangeSensorConfigurationRec>();
				for (int i = 0; i < m_QueryRangeSensorConfigurationRec.size(); i++)
				{
					m_QueryRangeSensorConfigurationRec.get(i).setParent(this);
				}
			}
			
			public RangeSensorConfigurationList(RangeSensorConfigurationList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_QueryRangeSensorConfigurationRec = new ArrayList<QueryRangeSensorConfigurationRec>();
				for (int i = 0; i < m_QueryRangeSensorConfigurationRec.size(); i++)
				{
					m_QueryRangeSensorConfigurationRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_QueryRangeSensorConfigurationRec.clear();
				
				for (int i = 0; i < value.m_QueryRangeSensorConfigurationRec.size(); i++)
				{
					m_QueryRangeSensorConfigurationRec.add(value.m_QueryRangeSensorConfigurationRec.get(i));
					m_QueryRangeSensorConfigurationRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected RangeSensorConfigurationList m_RangeSensorConfigurationList;
	
		public QueryRangeSensorConfiguration.Body.RangeSensorConfigurationList getRangeSensorConfigurationList()
		{
			return m_RangeSensorConfigurationList;
		}
		
		public void setRangeSensorConfigurationList(RangeSensorConfigurationList value)
		{
			m_RangeSensorConfigurationList = value;
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
			
			size += m_RangeSensorConfigurationList.getSize();
			
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
			
			m_RangeSensorConfigurationList.encode(bytes, pos);
			pos += m_RangeSensorConfigurationList.getSize();
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
			
			m_RangeSensorConfigurationList.decode(bytes, pos);
			pos += m_RangeSensorConfigurationList.getSize();
		}
		
		public QueryRangeSensorConfiguration.Body assign(Body value)
		{
			m_RangeSensorConfigurationList = value.m_RangeSensorConfigurationList;
			m_RangeSensorConfigurationList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_RangeSensorConfigurationList.isEqual(value.m_RangeSensorConfigurationList))
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
			m_RangeSensorConfigurationList = new RangeSensorConfigurationList();
			m_RangeSensorConfigurationList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_RangeSensorConfigurationList = new RangeSensorConfigurationList();
			m_RangeSensorConfigurationList.setParent(this);
			
			/// Copy the values
			m_RangeSensorConfigurationList = value.m_RangeSensorConfigurationList;
			m_RangeSensorConfigurationList.setParent(this);
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
	public QueryRangeSensorConfiguration.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public QueryRangeSensorConfiguration.Body getBody()
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
	
	public QueryRangeSensorConfiguration setAs(QueryRangeSensorConfiguration value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(QueryRangeSensorConfiguration value)
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
	
	public boolean notEquals(QueryRangeSensorConfiguration value)
	{
		return !isEqual(value);
	}
	
	public QueryRangeSensorConfiguration()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  QueryRangeSensorConfiguration(QueryRangeSensorConfiguration value)
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
