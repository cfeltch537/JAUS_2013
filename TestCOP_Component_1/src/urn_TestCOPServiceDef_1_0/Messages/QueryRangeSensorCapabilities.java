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

public class QueryRangeSensorCapabilities extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x2801;
	
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
			
			public QueryRangeSensorCapabilities.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x2801;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x2801;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public QueryRangeSensorCapabilities.AppHeader.HeaderRec getHeaderRec()
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
		
		public QueryRangeSensorCapabilities.AppHeader assign(AppHeader value)
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
		public static class  RangeSensorCapabilitiesList
		{
			public static class  QueryRangeSensorCapabilitiesRec
			{
			
				protected RangeSensorCapabilitiesList m_parent;
				protected int m_SensorID;
				protected int m_QueryPresenceVector;
			
				public void setParent(RangeSensorCapabilitiesList parent)
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
				
				public QueryRangeSensorCapabilities.Body.RangeSensorCapabilitiesList.QueryRangeSensorCapabilitiesRec assign(QueryRangeSensorCapabilitiesRec value)
				{
					m_SensorID = value.m_SensorID;
					m_QueryPresenceVector = value.m_QueryPresenceVector;
					
					return this;
				}
				
				public boolean isEqual(QueryRangeSensorCapabilitiesRec value)
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
				
				public boolean notEquals(QueryRangeSensorCapabilitiesRec value)
				{
					return !this.isEqual(value);
				}
				
				public QueryRangeSensorCapabilitiesRec()
				{
					m_parent = null;
					m_SensorID = 0;
					m_QueryPresenceVector = 0;
				}
				
				public QueryRangeSensorCapabilitiesRec(QueryRangeSensorCapabilitiesRec value)
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
			protected ArrayList<QueryRangeSensorCapabilitiesRec> m_QueryRangeSensorCapabilitiesRec;
		
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
				return (long) m_QueryRangeSensorCapabilitiesRec.size();
			}
			
			public QueryRangeSensorCapabilities.Body.RangeSensorCapabilitiesList.QueryRangeSensorCapabilitiesRec getElement(int index)
			{
				return m_QueryRangeSensorCapabilitiesRec.get(index);
			}
			
			public void setElement(int index, QueryRangeSensorCapabilitiesRec value)
			{
				if(m_QueryRangeSensorCapabilitiesRec.size()-1 < index)
				{
					return;
				}
				
				m_QueryRangeSensorCapabilitiesRec.set(index, value);
				m_QueryRangeSensorCapabilitiesRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(QueryRangeSensorCapabilitiesRec value)
			{
				m_QueryRangeSensorCapabilitiesRec.add(value);
				m_QueryRangeSensorCapabilitiesRec.get(m_QueryRangeSensorCapabilitiesRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_QueryRangeSensorCapabilitiesRec.size()-1 < index)
				{
					return 1;
				}
				
				m_QueryRangeSensorCapabilitiesRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_QueryRangeSensorCapabilitiesRec.remove(m_QueryRangeSensorCapabilitiesRec.size()-1);
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
				for (int i = 0; i < m_QueryRangeSensorCapabilitiesRec.size(); i++)
				{
					size += m_QueryRangeSensorCapabilitiesRec.get(i).getSize();
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
				
				int size = (int) m_QueryRangeSensorCapabilitiesRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_QueryRangeSensorCapabilitiesRec.size(); i++)
				{
					m_QueryRangeSensorCapabilitiesRec.get(i).encode(bytes, pos);
					pos += m_QueryRangeSensorCapabilitiesRec.get(i).getSize();
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
				m_QueryRangeSensorCapabilitiesRec = new ArrayList<QueryRangeSensorCapabilitiesRec>();
				for (int i = 0; i <  size; i++)
				{
					QueryRangeSensorCapabilitiesRec item = new QueryRangeSensorCapabilitiesRec();
					item.decode(bytes, pos);
					m_QueryRangeSensorCapabilitiesRec.add(item);
					pos += item.getSize();
				}
			}
			
			public QueryRangeSensorCapabilities.Body.RangeSensorCapabilitiesList assign(RangeSensorCapabilitiesList value)
			{
				m_QueryRangeSensorCapabilitiesRec.clear();
				
				for (int i = 0; i < value.m_QueryRangeSensorCapabilitiesRec.size(); i++)
				{
					m_QueryRangeSensorCapabilitiesRec.add(value.m_QueryRangeSensorCapabilitiesRec.get(i));
					m_QueryRangeSensorCapabilitiesRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(RangeSensorCapabilitiesList value)
			{
				for (int i = 0; i < m_QueryRangeSensorCapabilitiesRec.size(); i++)
				{
					if (!m_QueryRangeSensorCapabilitiesRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(RangeSensorCapabilitiesList value)
			{
				return !this.isEqual(value);
			}
			
			public RangeSensorCapabilitiesList()
			{
				m_parent = null;
				m_QueryRangeSensorCapabilitiesRec = new ArrayList<QueryRangeSensorCapabilitiesRec>();
				for (int i = 0; i < m_QueryRangeSensorCapabilitiesRec.size(); i++)
				{
					m_QueryRangeSensorCapabilitiesRec.get(i).setParent(this);
				}
			}
			
			public RangeSensorCapabilitiesList(RangeSensorCapabilitiesList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_QueryRangeSensorCapabilitiesRec = new ArrayList<QueryRangeSensorCapabilitiesRec>();
				for (int i = 0; i < m_QueryRangeSensorCapabilitiesRec.size(); i++)
				{
					m_QueryRangeSensorCapabilitiesRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_QueryRangeSensorCapabilitiesRec.clear();
				
				for (int i = 0; i < value.m_QueryRangeSensorCapabilitiesRec.size(); i++)
				{
					m_QueryRangeSensorCapabilitiesRec.add(value.m_QueryRangeSensorCapabilitiesRec.get(i));
					m_QueryRangeSensorCapabilitiesRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected RangeSensorCapabilitiesList m_RangeSensorCapabilitiesList;
	
		public QueryRangeSensorCapabilities.Body.RangeSensorCapabilitiesList getRangeSensorCapabilitiesList()
		{
			return m_RangeSensorCapabilitiesList;
		}
		
		public void setRangeSensorCapabilitiesList(RangeSensorCapabilitiesList value)
		{
			m_RangeSensorCapabilitiesList = value;
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
			
			size += m_RangeSensorCapabilitiesList.getSize();
			
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
			
			m_RangeSensorCapabilitiesList.encode(bytes, pos);
			pos += m_RangeSensorCapabilitiesList.getSize();
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
			
			m_RangeSensorCapabilitiesList.decode(bytes, pos);
			pos += m_RangeSensorCapabilitiesList.getSize();
		}
		
		public QueryRangeSensorCapabilities.Body assign(Body value)
		{
			m_RangeSensorCapabilitiesList = value.m_RangeSensorCapabilitiesList;
			m_RangeSensorCapabilitiesList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_RangeSensorCapabilitiesList.isEqual(value.m_RangeSensorCapabilitiesList))
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
			m_RangeSensorCapabilitiesList = new RangeSensorCapabilitiesList();
			m_RangeSensorCapabilitiesList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_RangeSensorCapabilitiesList = new RangeSensorCapabilitiesList();
			m_RangeSensorCapabilitiesList.setParent(this);
			
			/// Copy the values
			m_RangeSensorCapabilitiesList = value.m_RangeSensorCapabilitiesList;
			m_RangeSensorCapabilitiesList.setParent(this);
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
	public QueryRangeSensorCapabilities.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public QueryRangeSensorCapabilities.Body getBody()
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
	
	public QueryRangeSensorCapabilities setAs(QueryRangeSensorCapabilities value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(QueryRangeSensorCapabilities value)
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
	
	public boolean notEquals(QueryRangeSensorCapabilities value)
	{
		return !isEqual(value);
	}
	
	public QueryRangeSensorCapabilities()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  QueryRangeSensorCapabilities(QueryRangeSensorCapabilities value)
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
