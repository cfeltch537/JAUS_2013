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

public class QueryVisualSensorCapabilities extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x2806;
	
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
			
			public QueryVisualSensorCapabilities.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x2806;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x2806;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public QueryVisualSensorCapabilities.AppHeader.HeaderRec getHeaderRec()
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
		
		public QueryVisualSensorCapabilities.AppHeader assign(AppHeader value)
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
		public static class  QueryVisualSensorCapabilitiesList
		{
			public static class  QueryVisualSensorCapabilitiesRec
			{
			
				protected QueryVisualSensorCapabilitiesList m_parent;
				protected int m_SensorID;
				protected int m_QueryPresenceVector;
			
				public void setParent(QueryVisualSensorCapabilitiesList parent)
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
				
				public QueryVisualSensorCapabilities.Body.QueryVisualSensorCapabilitiesList.QueryVisualSensorCapabilitiesRec assign(QueryVisualSensorCapabilitiesRec value)
				{
					m_SensorID = value.m_SensorID;
					m_QueryPresenceVector = value.m_QueryPresenceVector;
					
					return this;
				}
				
				public boolean isEqual(QueryVisualSensorCapabilitiesRec value)
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
				
				public boolean notEquals(QueryVisualSensorCapabilitiesRec value)
				{
					return !this.isEqual(value);
				}
				
				public QueryVisualSensorCapabilitiesRec()
				{
					m_parent = null;
					m_SensorID = 0;
					m_QueryPresenceVector = 0;
				}
				
				public QueryVisualSensorCapabilitiesRec(QueryVisualSensorCapabilitiesRec value)
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
			protected ArrayList<QueryVisualSensorCapabilitiesRec> m_QueryVisualSensorCapabilitiesRec;
		
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
				return (long) m_QueryVisualSensorCapabilitiesRec.size();
			}
			
			public QueryVisualSensorCapabilities.Body.QueryVisualSensorCapabilitiesList.QueryVisualSensorCapabilitiesRec getElement(int index)
			{
				return m_QueryVisualSensorCapabilitiesRec.get(index);
			}
			
			public void setElement(int index, QueryVisualSensorCapabilitiesRec value)
			{
				if(m_QueryVisualSensorCapabilitiesRec.size()-1 < index)
				{
					return;
				}
				
				m_QueryVisualSensorCapabilitiesRec.set(index, value);
				m_QueryVisualSensorCapabilitiesRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(QueryVisualSensorCapabilitiesRec value)
			{
				m_QueryVisualSensorCapabilitiesRec.add(value);
				m_QueryVisualSensorCapabilitiesRec.get(m_QueryVisualSensorCapabilitiesRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_QueryVisualSensorCapabilitiesRec.size()-1 < index)
				{
					return 1;
				}
				
				m_QueryVisualSensorCapabilitiesRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_QueryVisualSensorCapabilitiesRec.remove(m_QueryVisualSensorCapabilitiesRec.size()-1);
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
				for (int i = 0; i < m_QueryVisualSensorCapabilitiesRec.size(); i++)
				{
					size += m_QueryVisualSensorCapabilitiesRec.get(i).getSize();
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
				
				int size = (int) m_QueryVisualSensorCapabilitiesRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_QueryVisualSensorCapabilitiesRec.size(); i++)
				{
					m_QueryVisualSensorCapabilitiesRec.get(i).encode(bytes, pos);
					pos += m_QueryVisualSensorCapabilitiesRec.get(i).getSize();
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
				m_QueryVisualSensorCapabilitiesRec = new ArrayList<QueryVisualSensorCapabilitiesRec>();
				for (int i = 0; i <  size; i++)
				{
					QueryVisualSensorCapabilitiesRec item = new QueryVisualSensorCapabilitiesRec();
					item.decode(bytes, pos);
					m_QueryVisualSensorCapabilitiesRec.add(item);
					pos += item.getSize();
				}
			}
			
			public QueryVisualSensorCapabilities.Body.QueryVisualSensorCapabilitiesList assign(QueryVisualSensorCapabilitiesList value)
			{
				m_QueryVisualSensorCapabilitiesRec.clear();
				
				for (int i = 0; i < value.m_QueryVisualSensorCapabilitiesRec.size(); i++)
				{
					m_QueryVisualSensorCapabilitiesRec.add(value.m_QueryVisualSensorCapabilitiesRec.get(i));
					m_QueryVisualSensorCapabilitiesRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(QueryVisualSensorCapabilitiesList value)
			{
				for (int i = 0; i < m_QueryVisualSensorCapabilitiesRec.size(); i++)
				{
					if (!m_QueryVisualSensorCapabilitiesRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(QueryVisualSensorCapabilitiesList value)
			{
				return !this.isEqual(value);
			}
			
			public QueryVisualSensorCapabilitiesList()
			{
				m_parent = null;
				m_QueryVisualSensorCapabilitiesRec = new ArrayList<QueryVisualSensorCapabilitiesRec>();
				for (int i = 0; i < m_QueryVisualSensorCapabilitiesRec.size(); i++)
				{
					m_QueryVisualSensorCapabilitiesRec.get(i).setParent(this);
				}
			}
			
			public QueryVisualSensorCapabilitiesList(QueryVisualSensorCapabilitiesList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_QueryVisualSensorCapabilitiesRec = new ArrayList<QueryVisualSensorCapabilitiesRec>();
				for (int i = 0; i < m_QueryVisualSensorCapabilitiesRec.size(); i++)
				{
					m_QueryVisualSensorCapabilitiesRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_QueryVisualSensorCapabilitiesRec.clear();
				
				for (int i = 0; i < value.m_QueryVisualSensorCapabilitiesRec.size(); i++)
				{
					m_QueryVisualSensorCapabilitiesRec.add(value.m_QueryVisualSensorCapabilitiesRec.get(i));
					m_QueryVisualSensorCapabilitiesRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected QueryVisualSensorCapabilitiesList m_QueryVisualSensorCapabilitiesList;
	
		public QueryVisualSensorCapabilities.Body.QueryVisualSensorCapabilitiesList getQueryVisualSensorCapabilitiesList()
		{
			return m_QueryVisualSensorCapabilitiesList;
		}
		
		public void setQueryVisualSensorCapabilitiesList(QueryVisualSensorCapabilitiesList value)
		{
			m_QueryVisualSensorCapabilitiesList = value;
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
			
			size += m_QueryVisualSensorCapabilitiesList.getSize();
			
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
			
			m_QueryVisualSensorCapabilitiesList.encode(bytes, pos);
			pos += m_QueryVisualSensorCapabilitiesList.getSize();
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
			
			m_QueryVisualSensorCapabilitiesList.decode(bytes, pos);
			pos += m_QueryVisualSensorCapabilitiesList.getSize();
		}
		
		public QueryVisualSensorCapabilities.Body assign(Body value)
		{
			m_QueryVisualSensorCapabilitiesList = value.m_QueryVisualSensorCapabilitiesList;
			m_QueryVisualSensorCapabilitiesList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_QueryVisualSensorCapabilitiesList.isEqual(value.m_QueryVisualSensorCapabilitiesList))
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
			m_QueryVisualSensorCapabilitiesList = new QueryVisualSensorCapabilitiesList();
			m_QueryVisualSensorCapabilitiesList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_QueryVisualSensorCapabilitiesList = new QueryVisualSensorCapabilitiesList();
			m_QueryVisualSensorCapabilitiesList.setParent(this);
			
			/// Copy the values
			m_QueryVisualSensorCapabilitiesList = value.m_QueryVisualSensorCapabilitiesList;
			m_QueryVisualSensorCapabilitiesList.setParent(this);
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
	public QueryVisualSensorCapabilities.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public QueryVisualSensorCapabilities.Body getBody()
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
	
	public QueryVisualSensorCapabilities setAs(QueryVisualSensorCapabilities value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(QueryVisualSensorCapabilities value)
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
	
	public boolean notEquals(QueryVisualSensorCapabilities value)
	{
		return !isEqual(value);
	}
	
	public QueryVisualSensorCapabilities()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  QueryVisualSensorCapabilities(QueryVisualSensorCapabilities value)
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
