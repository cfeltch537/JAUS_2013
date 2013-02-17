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

public class QueryRangeSensorData extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x2803;
	
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
			
			public QueryRangeSensorData.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x2803;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x2803;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public QueryRangeSensorData.AppHeader.HeaderRec getHeaderRec()
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
		
		public QueryRangeSensorData.AppHeader assign(AppHeader value)
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
		public static class  QueryRangeSensorDataList
		{
			public static class  QueryRangeSensorDataRec
			{
			
				protected QueryRangeSensorDataList m_parent;
				protected int m_SensorID;
				protected short m_ReportCoordinateSystem;
				protected int m_QueryPresenceVector;
			
				public void setParent(QueryRangeSensorDataList parent)
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
				
				public short getReportCoordinateSystem()
				{
					return m_ReportCoordinateSystem;
				}
				
				public void setReportCoordinateSystem(short value)
				{
					if ((value == 0) || (value == 1))
					{
						m_ReportCoordinateSystem = value;
						setParentPresenceVector();
					}
					return;
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
					size += JausUtils.getNumBytes("byte");
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
					bytes.put(pos, (byte) m_ReportCoordinateSystem);
					pos += JausUtils.getNumBytes("byte");
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
					m_ReportCoordinateSystem = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
					m_QueryPresenceVector = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				
				public QueryRangeSensorData.Body.QueryRangeSensorDataList.QueryRangeSensorDataRec assign(QueryRangeSensorDataRec value)
				{
					m_SensorID = value.m_SensorID;
					m_ReportCoordinateSystem = value.m_ReportCoordinateSystem;
					m_QueryPresenceVector = value.m_QueryPresenceVector;
					
					return this;
				}
				
				public boolean isEqual(QueryRangeSensorDataRec value)
				{
					if (m_SensorID != value.getSensorID())
					{
						return false;
					}
					if (m_ReportCoordinateSystem != value.getReportCoordinateSystem())
					{
						return false;
					}
					if (m_QueryPresenceVector != value.getQueryPresenceVector())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(QueryRangeSensorDataRec value)
				{
					return !this.isEqual(value);
				}
				
				public QueryRangeSensorDataRec()
				{
					m_parent = null;
					m_SensorID = 0;
					m_ReportCoordinateSystem = 0;
					m_QueryPresenceVector = 0;
				}
				
				public QueryRangeSensorDataRec(QueryRangeSensorDataRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_SensorID = 0;
					m_ReportCoordinateSystem = 0;
					m_QueryPresenceVector = 0;
					
					/// Copy the values
					m_SensorID = value.m_SensorID;
					m_ReportCoordinateSystem = value.m_ReportCoordinateSystem;
					m_QueryPresenceVector = value.m_QueryPresenceVector;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<QueryRangeSensorDataRec> m_QueryRangeSensorDataRec;
		
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
				return (long) m_QueryRangeSensorDataRec.size();
			}
			
			public QueryRangeSensorData.Body.QueryRangeSensorDataList.QueryRangeSensorDataRec getElement(int index)
			{
				return m_QueryRangeSensorDataRec.get(index);
			}
			
			public void setElement(int index, QueryRangeSensorDataRec value)
			{
				if(m_QueryRangeSensorDataRec.size()-1 < index)
				{
					return;
				}
				
				m_QueryRangeSensorDataRec.set(index, value);
				m_QueryRangeSensorDataRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(QueryRangeSensorDataRec value)
			{
				m_QueryRangeSensorDataRec.add(value);
				m_QueryRangeSensorDataRec.get(m_QueryRangeSensorDataRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_QueryRangeSensorDataRec.size()-1 < index)
				{
					return 1;
				}
				
				m_QueryRangeSensorDataRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_QueryRangeSensorDataRec.remove(m_QueryRangeSensorDataRec.size()-1);
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
				for (int i = 0; i < m_QueryRangeSensorDataRec.size(); i++)
				{
					size += m_QueryRangeSensorDataRec.get(i).getSize();
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
				
				int size = (int) m_QueryRangeSensorDataRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_QueryRangeSensorDataRec.size(); i++)
				{
					m_QueryRangeSensorDataRec.get(i).encode(bytes, pos);
					pos += m_QueryRangeSensorDataRec.get(i).getSize();
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
				m_QueryRangeSensorDataRec = new ArrayList<QueryRangeSensorDataRec>();
				for (int i = 0; i <  size; i++)
				{
					QueryRangeSensorDataRec item = new QueryRangeSensorDataRec();
					item.decode(bytes, pos);
					m_QueryRangeSensorDataRec.add(item);
					pos += item.getSize();
				}
			}
			
			public QueryRangeSensorData.Body.QueryRangeSensorDataList assign(QueryRangeSensorDataList value)
			{
				m_QueryRangeSensorDataRec.clear();
				
				for (int i = 0; i < value.m_QueryRangeSensorDataRec.size(); i++)
				{
					m_QueryRangeSensorDataRec.add(value.m_QueryRangeSensorDataRec.get(i));
					m_QueryRangeSensorDataRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(QueryRangeSensorDataList value)
			{
				for (int i = 0; i < m_QueryRangeSensorDataRec.size(); i++)
				{
					if (!m_QueryRangeSensorDataRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(QueryRangeSensorDataList value)
			{
				return !this.isEqual(value);
			}
			
			public QueryRangeSensorDataList()
			{
				m_parent = null;
				m_QueryRangeSensorDataRec = new ArrayList<QueryRangeSensorDataRec>();
				for (int i = 0; i < m_QueryRangeSensorDataRec.size(); i++)
				{
					m_QueryRangeSensorDataRec.get(i).setParent(this);
				}
			}
			
			public QueryRangeSensorDataList(QueryRangeSensorDataList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_QueryRangeSensorDataRec = new ArrayList<QueryRangeSensorDataRec>();
				for (int i = 0; i < m_QueryRangeSensorDataRec.size(); i++)
				{
					m_QueryRangeSensorDataRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_QueryRangeSensorDataRec.clear();
				
				for (int i = 0; i < value.m_QueryRangeSensorDataRec.size(); i++)
				{
					m_QueryRangeSensorDataRec.add(value.m_QueryRangeSensorDataRec.get(i));
					m_QueryRangeSensorDataRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected QueryRangeSensorDataList m_QueryRangeSensorDataList;
	
		public QueryRangeSensorData.Body.QueryRangeSensorDataList getQueryRangeSensorDataList()
		{
			return m_QueryRangeSensorDataList;
		}
		
		public void setQueryRangeSensorDataList(QueryRangeSensorDataList value)
		{
			m_QueryRangeSensorDataList = value;
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
			
			size += m_QueryRangeSensorDataList.getSize();
			
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
			
			m_QueryRangeSensorDataList.encode(bytes, pos);
			pos += m_QueryRangeSensorDataList.getSize();
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
			
			m_QueryRangeSensorDataList.decode(bytes, pos);
			pos += m_QueryRangeSensorDataList.getSize();
		}
		
		public QueryRangeSensorData.Body assign(Body value)
		{
			m_QueryRangeSensorDataList = value.m_QueryRangeSensorDataList;
			m_QueryRangeSensorDataList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_QueryRangeSensorDataList.isEqual(value.m_QueryRangeSensorDataList))
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
			m_QueryRangeSensorDataList = new QueryRangeSensorDataList();
			m_QueryRangeSensorDataList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_QueryRangeSensorDataList = new QueryRangeSensorDataList();
			m_QueryRangeSensorDataList.setParent(this);
			
			/// Copy the values
			m_QueryRangeSensorDataList = value.m_QueryRangeSensorDataList;
			m_QueryRangeSensorDataList.setParent(this);
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
	public QueryRangeSensorData.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public QueryRangeSensorData.Body getBody()
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
	
	public QueryRangeSensorData setAs(QueryRangeSensorData value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(QueryRangeSensorData value)
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
	
	public boolean notEquals(QueryRangeSensorData value)
	{
		return !isEqual(value);
	}
	
	public QueryRangeSensorData()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  QueryRangeSensorData(QueryRangeSensorData value)
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
