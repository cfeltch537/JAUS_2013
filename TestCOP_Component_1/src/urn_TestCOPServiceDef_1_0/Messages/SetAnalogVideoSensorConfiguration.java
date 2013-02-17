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

public class SetAnalogVideoSensorConfiguration extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x0806;
	
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
			
			public SetAnalogVideoSensorConfiguration.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x0806;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x0806;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public SetAnalogVideoSensorConfiguration.AppHeader.HeaderRec getHeaderRec()
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
		
		public SetAnalogVideoSensorConfiguration.AppHeader assign(AppHeader value)
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
		public static class  AnalogVideoSensorConfigurationSequence
		{
			public static class  RequestIdRec
			{
			
				protected AnalogVideoSensorConfigurationSequence m_parent;
				protected short m_RequestID;
			
				public void setParent(AnalogVideoSensorConfigurationSequence parent)
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
				
				public short getRequestID()
				{
					return m_RequestID;
				}
				
				public void setRequestID(short value)
				{
					m_RequestID = value;
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
					
					bytes.put(pos, (byte) m_RequestID);
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
					
					m_RequestID = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				
				public SetAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationSequence.RequestIdRec assign(RequestIdRec value)
				{
					m_RequestID = value.m_RequestID;
					
					return this;
				}
				
				public boolean isEqual(RequestIdRec value)
				{
					if (m_RequestID != value.getRequestID())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(RequestIdRec value)
				{
					return !this.isEqual(value);
				}
				
				public RequestIdRec()
				{
					m_parent = null;
					m_RequestID = 0;
				}
				
				public RequestIdRec(RequestIdRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_RequestID = 0;
					
					/// Copy the values
					m_RequestID = value.m_RequestID;
				}
				
				public void finalize()
				{
				}
				
			}
			public static class  AnalogVideoSensorList
			{
				public static class  AnalogVideoSensorConfigurationRec
				{
				
					protected AnalogVideoSensorList m_parent;
					protected int m_SensorID;
					protected short m_AnalogFormat;
				
					public void setParent(AnalogVideoSensorList parent)
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
					
					public SetAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationSequence.AnalogVideoSensorList.AnalogVideoSensorConfigurationRec assign(AnalogVideoSensorConfigurationRec value)
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
			
			
				protected AnalogVideoSensorConfigurationSequence m_parent;
				protected ArrayList<AnalogVideoSensorConfigurationRec> m_AnalogVideoSensorConfigurationRec;
			
				public void setParent(AnalogVideoSensorConfigurationSequence parent)
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
				
				public SetAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationSequence.AnalogVideoSensorList.AnalogVideoSensorConfigurationRec getElement(int index)
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
				
				public SetAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationSequence.AnalogVideoSensorList assign(AnalogVideoSensorList value)
				{
					m_AnalogVideoSensorConfigurationRec.clear();
					
					for (int i = 0; i < value.m_AnalogVideoSensorConfigurationRec.size(); i++)
					{
						m_AnalogVideoSensorConfigurationRec.add(value.m_AnalogVideoSensorConfigurationRec.get(i));
						m_AnalogVideoSensorConfigurationRec.get(i).setParent(this);
					}
					
					return this;
				}
				
				public boolean isEqual(AnalogVideoSensorList value)
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
				
				public boolean notEquals(AnalogVideoSensorList value)
				{
					return !this.isEqual(value);
				}
				
				public AnalogVideoSensorList()
				{
					m_parent = null;
					m_AnalogVideoSensorConfigurationRec = new ArrayList<AnalogVideoSensorConfigurationRec>();
					for (int i = 0; i < m_AnalogVideoSensorConfigurationRec.size(); i++)
					{
						m_AnalogVideoSensorConfigurationRec.get(i).setParent(this);
					}
				}
				
				public AnalogVideoSensorList(AnalogVideoSensorList value)
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
		
		
			protected Body m_parent;
			protected RequestIdRec m_RequestIdRec;
			protected AnalogVideoSensorList m_AnalogVideoSensorList;
		
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
			
			public SetAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationSequence.RequestIdRec getRequestIdRec()
			{
				return m_RequestIdRec;
			}
			
			public void setRequestIdRec(RequestIdRec value)
			{
				m_RequestIdRec = value;
				setParentPresenceVector();
			}
			
			public SetAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationSequence.AnalogVideoSensorList getAnalogVideoSensorList()
			{
				return m_AnalogVideoSensorList;
			}
			
			public void setAnalogVideoSensorList(AnalogVideoSensorList value)
			{
				m_AnalogVideoSensorList = value;
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
				
				size += m_RequestIdRec.getSize();
				size += m_AnalogVideoSensorList.getSize();
				
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
				
				m_RequestIdRec.encode(bytes, pos);
				pos += m_RequestIdRec.getSize();
				m_AnalogVideoSensorList.encode(bytes, pos);
				pos += m_AnalogVideoSensorList.getSize();
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
				
				m_RequestIdRec.decode(bytes, pos);
				pos += m_RequestIdRec.getSize();
				m_AnalogVideoSensorList.decode(bytes, pos);
				pos += m_AnalogVideoSensorList.getSize();
			}
			
			public SetAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationSequence assign(AnalogVideoSensorConfigurationSequence value)
			{
				m_RequestIdRec = value.m_RequestIdRec;
				m_RequestIdRec.setParent(this);
				m_RequestIdRec = value.m_RequestIdRec;
				m_AnalogVideoSensorList = value.m_AnalogVideoSensorList;
				m_AnalogVideoSensorList.setParent(this);
				m_AnalogVideoSensorList = value.m_AnalogVideoSensorList;
				
				return this;
			}
			
			public boolean isEqual(AnalogVideoSensorConfigurationSequence value)
			{
				if (!m_RequestIdRec.isEqual(value.getRequestIdRec()))
				{
					return false;
				}
				
				if (!m_RequestIdRec.isEqual(value.getRequestIdRec()))
				{
					return false;
				}
				if (!m_AnalogVideoSensorList.isEqual(value.m_AnalogVideoSensorList))
				{
					return false;
				}
				
				if (!m_AnalogVideoSensorList.isEqual(value.getAnalogVideoSensorList()))
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(AnalogVideoSensorConfigurationSequence value)
			{
				return !this.isEqual(value);
			}
			
			public AnalogVideoSensorConfigurationSequence()
			{
				m_parent = null;
				m_RequestIdRec = new RequestIdRec();
				m_RequestIdRec.setParent(this);
				m_AnalogVideoSensorList = new AnalogVideoSensorList();
				m_AnalogVideoSensorList.setParent(this);
			}
			
			public AnalogVideoSensorConfigurationSequence(AnalogVideoSensorConfigurationSequence value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_RequestIdRec = new RequestIdRec();
				m_RequestIdRec.setParent(this);
				m_AnalogVideoSensorList = new AnalogVideoSensorList();
				m_AnalogVideoSensorList.setParent(this);
				
				/// Copy the values
				m_RequestIdRec = value.m_RequestIdRec;
				m_RequestIdRec.setParent(this);
				m_RequestIdRec = value.m_RequestIdRec;
				m_AnalogVideoSensorList = value.m_AnalogVideoSensorList;
				m_AnalogVideoSensorList.setParent(this);
				m_AnalogVideoSensorList = value.m_AnalogVideoSensorList;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected AnalogVideoSensorConfigurationSequence m_AnalogVideoSensorConfigurationSequence;
	
		public SetAnalogVideoSensorConfiguration.Body.AnalogVideoSensorConfigurationSequence getAnalogVideoSensorConfigurationSequence()
		{
			return m_AnalogVideoSensorConfigurationSequence;
		}
		
		public int setAnalogVideoSensorConfigurationSequence(AnalogVideoSensorConfigurationSequence value)
		{
			m_AnalogVideoSensorConfigurationSequence = value;
			setParentPresenceVector();
			return 0;
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
			
			size += m_AnalogVideoSensorConfigurationSequence.getSize();
			
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
			
			m_AnalogVideoSensorConfigurationSequence.encode(bytes, pos);
			pos += m_AnalogVideoSensorConfigurationSequence.getSize();
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
			
			m_AnalogVideoSensorConfigurationSequence.decode(bytes, pos);
			pos += m_AnalogVideoSensorConfigurationSequence.getSize();
		}
		
		public SetAnalogVideoSensorConfiguration.Body assign(Body value)
		{
			m_AnalogVideoSensorConfigurationSequence = value.m_AnalogVideoSensorConfigurationSequence;
			m_AnalogVideoSensorConfigurationSequence.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_AnalogVideoSensorConfigurationSequence.isEqual(value.getAnalogVideoSensorConfigurationSequence()))
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
			m_AnalogVideoSensorConfigurationSequence = new AnalogVideoSensorConfigurationSequence();
			m_AnalogVideoSensorConfigurationSequence.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_AnalogVideoSensorConfigurationSequence = new AnalogVideoSensorConfigurationSequence();
			m_AnalogVideoSensorConfigurationSequence.setParent(this);
			
			/// Copy the values
			m_AnalogVideoSensorConfigurationSequence = value.m_AnalogVideoSensorConfigurationSequence;
			m_AnalogVideoSensorConfigurationSequence.setParent(this);
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
	public SetAnalogVideoSensorConfiguration.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public SetAnalogVideoSensorConfiguration.Body getBody()
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
	
	public SetAnalogVideoSensorConfiguration setAs(SetAnalogVideoSensorConfiguration value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(SetAnalogVideoSensorConfiguration value)
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
	
	public boolean notEquals(SetAnalogVideoSensorConfiguration value)
	{
		return !isEqual(value);
	}
	
	public SetAnalogVideoSensorConfiguration()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = true;
	}
	
	public  SetAnalogVideoSensorConfiguration(SetAnalogVideoSensorConfiguration value)
	{
		/// Initiliaze the protected variables
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = true;
		
		/// Copy the values
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
	}
	
}
