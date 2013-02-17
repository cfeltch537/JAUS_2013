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

public class QueryVisualSensorConfiguration extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x2807;
	
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
			
			public QueryVisualSensorConfiguration.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x2807;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x2807;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public QueryVisualSensorConfiguration.AppHeader.HeaderRec getHeaderRec()
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
		
		public QueryVisualSensorConfiguration.AppHeader assign(AppHeader value)
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
		public static class  QueryVisualSensorConfigurationList
		{
			public static class  QueryVisualSensorConfigurationRec
			{
			
				protected QueryVisualSensorConfigurationList m_parent;
				protected int m_SensorID;
				protected int m_QueryPresenceVector;
			
				public void setParent(QueryVisualSensorConfigurationList parent)
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
				
				public QueryVisualSensorConfiguration.Body.QueryVisualSensorConfigurationList.QueryVisualSensorConfigurationRec assign(QueryVisualSensorConfigurationRec value)
				{
					m_SensorID = value.m_SensorID;
					m_QueryPresenceVector = value.m_QueryPresenceVector;
					
					return this;
				}
				
				public boolean isEqual(QueryVisualSensorConfigurationRec value)
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
				
				public boolean notEquals(QueryVisualSensorConfigurationRec value)
				{
					return !this.isEqual(value);
				}
				
				public QueryVisualSensorConfigurationRec()
				{
					m_parent = null;
					m_SensorID = 0;
					m_QueryPresenceVector = 0;
				}
				
				public QueryVisualSensorConfigurationRec(QueryVisualSensorConfigurationRec value)
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
			protected ArrayList<QueryVisualSensorConfigurationRec> m_QueryVisualSensorConfigurationRec;
		
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
				return (long) m_QueryVisualSensorConfigurationRec.size();
			}
			
			public QueryVisualSensorConfiguration.Body.QueryVisualSensorConfigurationList.QueryVisualSensorConfigurationRec getElement(int index)
			{
				return m_QueryVisualSensorConfigurationRec.get(index);
			}
			
			public void setElement(int index, QueryVisualSensorConfigurationRec value)
			{
				if(m_QueryVisualSensorConfigurationRec.size()-1 < index)
				{
					return;
				}
				
				m_QueryVisualSensorConfigurationRec.set(index, value);
				m_QueryVisualSensorConfigurationRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(QueryVisualSensorConfigurationRec value)
			{
				m_QueryVisualSensorConfigurationRec.add(value);
				m_QueryVisualSensorConfigurationRec.get(m_QueryVisualSensorConfigurationRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_QueryVisualSensorConfigurationRec.size()-1 < index)
				{
					return 1;
				}
				
				m_QueryVisualSensorConfigurationRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_QueryVisualSensorConfigurationRec.remove(m_QueryVisualSensorConfigurationRec.size()-1);
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
				for (int i = 0; i < m_QueryVisualSensorConfigurationRec.size(); i++)
				{
					size += m_QueryVisualSensorConfigurationRec.get(i).getSize();
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
				
				int size = (int) m_QueryVisualSensorConfigurationRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_QueryVisualSensorConfigurationRec.size(); i++)
				{
					m_QueryVisualSensorConfigurationRec.get(i).encode(bytes, pos);
					pos += m_QueryVisualSensorConfigurationRec.get(i).getSize();
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
				m_QueryVisualSensorConfigurationRec = new ArrayList<QueryVisualSensorConfigurationRec>();
				for (int i = 0; i <  size; i++)
				{
					QueryVisualSensorConfigurationRec item = new QueryVisualSensorConfigurationRec();
					item.decode(bytes, pos);
					m_QueryVisualSensorConfigurationRec.add(item);
					pos += item.getSize();
				}
			}
			
			public QueryVisualSensorConfiguration.Body.QueryVisualSensorConfigurationList assign(QueryVisualSensorConfigurationList value)
			{
				m_QueryVisualSensorConfigurationRec.clear();
				
				for (int i = 0; i < value.m_QueryVisualSensorConfigurationRec.size(); i++)
				{
					m_QueryVisualSensorConfigurationRec.add(value.m_QueryVisualSensorConfigurationRec.get(i));
					m_QueryVisualSensorConfigurationRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(QueryVisualSensorConfigurationList value)
			{
				for (int i = 0; i < m_QueryVisualSensorConfigurationRec.size(); i++)
				{
					if (!m_QueryVisualSensorConfigurationRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(QueryVisualSensorConfigurationList value)
			{
				return !this.isEqual(value);
			}
			
			public QueryVisualSensorConfigurationList()
			{
				m_parent = null;
				m_QueryVisualSensorConfigurationRec = new ArrayList<QueryVisualSensorConfigurationRec>();
				for (int i = 0; i < m_QueryVisualSensorConfigurationRec.size(); i++)
				{
					m_QueryVisualSensorConfigurationRec.get(i).setParent(this);
				}
			}
			
			public QueryVisualSensorConfigurationList(QueryVisualSensorConfigurationList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_QueryVisualSensorConfigurationRec = new ArrayList<QueryVisualSensorConfigurationRec>();
				for (int i = 0; i < m_QueryVisualSensorConfigurationRec.size(); i++)
				{
					m_QueryVisualSensorConfigurationRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_QueryVisualSensorConfigurationRec.clear();
				
				for (int i = 0; i < value.m_QueryVisualSensorConfigurationRec.size(); i++)
				{
					m_QueryVisualSensorConfigurationRec.add(value.m_QueryVisualSensorConfigurationRec.get(i));
					m_QueryVisualSensorConfigurationRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected QueryVisualSensorConfigurationList m_QueryVisualSensorConfigurationList;
	
		public QueryVisualSensorConfiguration.Body.QueryVisualSensorConfigurationList getQueryVisualSensorConfigurationList()
		{
			return m_QueryVisualSensorConfigurationList;
		}
		
		public void setQueryVisualSensorConfigurationList(QueryVisualSensorConfigurationList value)
		{
			m_QueryVisualSensorConfigurationList = value;
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
			
			size += m_QueryVisualSensorConfigurationList.getSize();
			
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
			
			m_QueryVisualSensorConfigurationList.encode(bytes, pos);
			pos += m_QueryVisualSensorConfigurationList.getSize();
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
			
			m_QueryVisualSensorConfigurationList.decode(bytes, pos);
			pos += m_QueryVisualSensorConfigurationList.getSize();
		}
		
		public QueryVisualSensorConfiguration.Body assign(Body value)
		{
			m_QueryVisualSensorConfigurationList = value.m_QueryVisualSensorConfigurationList;
			m_QueryVisualSensorConfigurationList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_QueryVisualSensorConfigurationList.isEqual(value.m_QueryVisualSensorConfigurationList))
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
			m_QueryVisualSensorConfigurationList = new QueryVisualSensorConfigurationList();
			m_QueryVisualSensorConfigurationList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_QueryVisualSensorConfigurationList = new QueryVisualSensorConfigurationList();
			m_QueryVisualSensorConfigurationList.setParent(this);
			
			/// Copy the values
			m_QueryVisualSensorConfigurationList = value.m_QueryVisualSensorConfigurationList;
			m_QueryVisualSensorConfigurationList.setParent(this);
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
	public QueryVisualSensorConfiguration.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public QueryVisualSensorConfiguration.Body getBody()
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
	
	public QueryVisualSensorConfiguration setAs(QueryVisualSensorConfiguration value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(QueryVisualSensorConfiguration value)
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
	
	public boolean notEquals(QueryVisualSensorConfiguration value)
	{
		return !isEqual(value);
	}
	
	public QueryVisualSensorConfiguration()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  QueryVisualSensorConfiguration(QueryVisualSensorConfiguration value)
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
