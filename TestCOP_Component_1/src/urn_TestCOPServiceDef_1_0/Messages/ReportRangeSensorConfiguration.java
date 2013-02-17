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

public class ReportRangeSensorConfiguration extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4802;
	
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
			
			public ReportRangeSensorConfiguration.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4802;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4802;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportRangeSensorConfiguration.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportRangeSensorConfiguration.AppHeader assign(AppHeader value)
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
			public static class  RangeSensorConfigurationRec
			{
			
				protected RangeSensorConfigurationList m_parent;
				protected BitSet m_PresenceVector;
				protected int m_PresenceVectorTemp;
				protected int m_SensorID;
				protected long m_HorizontalFieldOfViewStartAngle;
				protected long m_HorizontalFieldOfViewStopAngle;
				protected long m_VerticalFieldOfViewStartAngle;
				protected long m_VerticalFieldOfViewStopAngle;
				protected int m_UpdateRate;
				protected long m_MinimumRange;
				protected long m_MaximumRange;
				protected short m_SensorState;
			
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
				
				public int getPresenceVector()
				{
					return m_PresenceVectorTemp;
				}
				
				protected void setPresenceVector(int index)
				{
					
					m_PresenceVector.set(index);
					m_PresenceVectorTemp = (int) JausUtils.getPVInt(m_PresenceVector);
				}
				
				public boolean checkPresenceVector(int index)
				{
					
					return m_PresenceVector.get(index);
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
				
				public boolean isHorizontalFieldOfViewStartAngleValid()
				{
					if (checkPresenceVector(0))
					{
						return true;
					}
					return false;
				}
				
				public double getHorizontalFieldOfViewStartAngle()
				{
					double value;
					
					double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
					double bias = -3.141592653589793;
					
					value = m_HorizontalFieldOfViewStartAngle * scaleFactor + bias;
					
					return value;
				}
				
				public void setHorizontalFieldOfViewStartAngle(double value)
				{
					if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
					{
						double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
						double bias = -3.141592653589793;
						
						m_HorizontalFieldOfViewStartAngle= (long)((value - bias) / scaleFactor);
						setPresenceVector(0);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isHorizontalFieldOfViewStopAngleValid()
				{
					if (checkPresenceVector(1))
					{
						return true;
					}
					return false;
				}
				
				public double getHorizontalFieldOfViewStopAngle()
				{
					double value;
					
					double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
					double bias = -3.141592653589793;
					
					value = m_HorizontalFieldOfViewStopAngle * scaleFactor + bias;
					
					return value;
				}
				
				public void setHorizontalFieldOfViewStopAngle(double value)
				{
					if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
					{
						double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
						double bias = -3.141592653589793;
						
						m_HorizontalFieldOfViewStopAngle= (long)((value - bias) / scaleFactor);
						setPresenceVector(1);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isVerticalFieldOfViewStartAngleValid()
				{
					if (checkPresenceVector(2))
					{
						return true;
					}
					return false;
				}
				
				public double getVerticalFieldOfViewStartAngle()
				{
					double value;
					
					double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
					double bias = -3.141592653589793;
					
					value = m_VerticalFieldOfViewStartAngle * scaleFactor + bias;
					
					return value;
				}
				
				public void setVerticalFieldOfViewStartAngle(double value)
				{
					if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
					{
						double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
						double bias = -3.141592653589793;
						
						m_VerticalFieldOfViewStartAngle= (long)((value - bias) / scaleFactor);
						setPresenceVector(2);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isVerticalFieldOfViewStopAngleValid()
				{
					if (checkPresenceVector(3))
					{
						return true;
					}
					return false;
				}
				
				public double getVerticalFieldOfViewStopAngle()
				{
					double value;
					
					double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
					double bias = -3.141592653589793;
					
					value = m_VerticalFieldOfViewStopAngle * scaleFactor + bias;
					
					return value;
				}
				
				public void setVerticalFieldOfViewStopAngle(double value)
				{
					if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
					{
						double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
						double bias = -3.141592653589793;
						
						m_VerticalFieldOfViewStopAngle= (long)((value - bias) / scaleFactor);
						setPresenceVector(3);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isUpdateRateValid()
				{
					if (checkPresenceVector(4))
					{
						return true;
					}
					return false;
				}
				
				public double getUpdateRate()
				{
					double value;
					
					double scaleFactor = ( 1000 - 0 ) / 65535.0;
					double bias = 0;
					
					value = m_UpdateRate * scaleFactor + bias;
					
					return value;
				}
				
				public void setUpdateRate(double value)
				{
					if ((value >= 0) && (value <= 1000))
					{
						double scaleFactor = ( 1000 - 0 ) / 65535.0;
						double bias = 0;
						
						m_UpdateRate= (int)((value - bias) / scaleFactor);
						setPresenceVector(4);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMinimumRangeValid()
				{
					if (checkPresenceVector(5))
					{
						return true;
					}
					return false;
				}
				
				public double getMinimumRange()
				{
					double value;
					
					double scaleFactor = ( 1000000.0 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					value = m_MinimumRange * scaleFactor + bias;
					
					return value;
				}
				
				public void setMinimumRange(double value)
				{
					if ((value >= 0) && (value <= 1000000.0))
					{
						double scaleFactor = ( 1000000.0 - 0 ) / 4.294967295E9;
						double bias = 0;
						
						m_MinimumRange= (long)((value - bias) / scaleFactor);
						setPresenceVector(5);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMaximumRangeValid()
				{
					if (checkPresenceVector(6))
					{
						return true;
					}
					return false;
				}
				
				public double getMaximumRange()
				{
					double value;
					
					double scaleFactor = ( 1000000.0 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					value = m_MaximumRange * scaleFactor + bias;
					
					return value;
				}
				
				public void setMaximumRange(double value)
				{
					if ((value >= 0) && (value <= 1000000.0))
					{
						double scaleFactor = ( 1000000.0 - 0 ) / 4.294967295E9;
						double bias = 0;
						
						m_MaximumRange= (long)((value - bias) / scaleFactor);
						setPresenceVector(6);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isSensorStateValid()
				{
					if (checkPresenceVector(7))
					{
						return true;
					}
					return false;
				}
				
				public short getSensorState()
				{
					return m_SensorState;
				}
				
				public void setSensorState(short value)
				{
					if ((value == 0) || (value == 1) || (value == 2))
					{
						m_SensorState = value;
						setPresenceVector(7);
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
					size += JausUtils.getNumBytes("short");
					if (checkPresenceVector(0))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(1))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(2))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(3))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(4))
					{
						size += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(5))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(6))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(7))
					{
						size += JausUtils.getNumBytes("byte");
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
					
					try
					{
						int m_PresenceVectorTemp = (int) JausUtils.getPVInt(m_PresenceVector);
					bytes.putShort(pos, (short) m_PresenceVectorTemp);
					pos += JausUtils.getNumBytes("short");
					}
					catch(Exception e)
					{
						logger.log(Level.SEVERE, null, e);
					}
					bytes.putShort(pos, (short) m_SensorID);
					pos += JausUtils.getNumBytes("short");
					if (checkPresenceVector(0))
					{
						bytes.putInt(pos, (int) m_HorizontalFieldOfViewStartAngle);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(1))
					{
						bytes.putInt(pos, (int) m_HorizontalFieldOfViewStopAngle);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(2))
					{
						bytes.putInt(pos, (int) m_VerticalFieldOfViewStartAngle);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(3))
					{
						bytes.putInt(pos, (int) m_VerticalFieldOfViewStopAngle);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(4))
					{
						bytes.putShort(pos, (short) m_UpdateRate);
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(5))
					{
						bytes.putInt(pos, (int) m_MinimumRange);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(6))
					{
						bytes.putInt(pos, (int) m_MaximumRange);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(7))
					{
						bytes.put(pos, (byte) m_SensorState);
						pos += JausUtils.getNumBytes("byte");
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
					
					try
					{
						int m_PresenceVectorTemp = 0;
					m_PresenceVectorTemp = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
					m_PresenceVector = JausUtils.setPV(m_PresenceVectorTemp);
					}
					catch(Exception e)
					{
						logger.log(Level.SEVERE, null, e);
					}
					m_SensorID = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
					if (checkPresenceVector(0))
					{
						m_HorizontalFieldOfViewStartAngle = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(1))
					{
						m_HorizontalFieldOfViewStopAngle = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(2))
					{
						m_VerticalFieldOfViewStartAngle = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(3))
					{
						m_VerticalFieldOfViewStopAngle = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(4))
					{
						m_UpdateRate = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(5))
					{
						m_MinimumRange = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(6))
					{
						m_MaximumRange = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(7))
					{
						m_SensorState = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
				}
				
				public ReportRangeSensorConfiguration.Body.RangeSensorConfigurationList.RangeSensorConfigurationRec assign(RangeSensorConfigurationRec value)
				{
					m_PresenceVector = value.m_PresenceVector;
					m_SensorID = value.m_SensorID;
					m_HorizontalFieldOfViewStartAngle = value.m_HorizontalFieldOfViewStartAngle;
					m_HorizontalFieldOfViewStopAngle = value.m_HorizontalFieldOfViewStopAngle;
					m_VerticalFieldOfViewStartAngle = value.m_VerticalFieldOfViewStartAngle;
					m_VerticalFieldOfViewStopAngle = value.m_VerticalFieldOfViewStopAngle;
					m_UpdateRate = value.m_UpdateRate;
					m_MinimumRange = value.m_MinimumRange;
					m_MaximumRange = value.m_MaximumRange;
					m_SensorState = value.m_SensorState;
					
					return this;
				}
				
				public boolean isEqual(RangeSensorConfigurationRec value)
				{
					if (!m_PresenceVector.equals(value.m_PresenceVector))
					{
						return false;
					}
					if (m_SensorID != value.getSensorID())
					{
						return false;
					}
					if (m_HorizontalFieldOfViewStartAngle != value.getHorizontalFieldOfViewStartAngle())
					{
						return false;
					}
					if (m_HorizontalFieldOfViewStopAngle != value.getHorizontalFieldOfViewStopAngle())
					{
						return false;
					}
					if (m_VerticalFieldOfViewStartAngle != value.getVerticalFieldOfViewStartAngle())
					{
						return false;
					}
					if (m_VerticalFieldOfViewStopAngle != value.getVerticalFieldOfViewStopAngle())
					{
						return false;
					}
					if (m_UpdateRate != value.getUpdateRate())
					{
						return false;
					}
					if (m_MinimumRange != value.getMinimumRange())
					{
						return false;
					}
					if (m_MaximumRange != value.getMaximumRange())
					{
						return false;
					}
					if (m_SensorState != value.getSensorState())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(RangeSensorConfigurationRec value)
				{
					return !this.isEqual(value);
				}
				
				public RangeSensorConfigurationRec()
				{
					m_parent = null;
					m_PresenceVector = new BitSet();
					m_PresenceVectorTemp = 0;
					m_SensorID = 0;
					m_HorizontalFieldOfViewStartAngle = 0;
					m_HorizontalFieldOfViewStopAngle = 0;
					m_VerticalFieldOfViewStartAngle = 0;
					m_VerticalFieldOfViewStopAngle = 0;
					m_UpdateRate = 0;
					m_MinimumRange = 0;
					m_MaximumRange = 0;
					m_SensorState = 0;
				}
				
				public RangeSensorConfigurationRec(RangeSensorConfigurationRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_PresenceVector = new BitSet();
					m_PresenceVectorTemp = 0;
					m_SensorID = 0;
					m_HorizontalFieldOfViewStartAngle = 0;
					m_HorizontalFieldOfViewStopAngle = 0;
					m_VerticalFieldOfViewStartAngle = 0;
					m_VerticalFieldOfViewStopAngle = 0;
					m_UpdateRate = 0;
					m_MinimumRange = 0;
					m_MaximumRange = 0;
					m_SensorState = 0;
					
					/// Copy the values
					m_PresenceVector = value.m_PresenceVector;
					m_SensorID = value.m_SensorID;
					m_HorizontalFieldOfViewStartAngle = value.m_HorizontalFieldOfViewStartAngle;
					m_HorizontalFieldOfViewStopAngle = value.m_HorizontalFieldOfViewStopAngle;
					m_VerticalFieldOfViewStartAngle = value.m_VerticalFieldOfViewStartAngle;
					m_VerticalFieldOfViewStopAngle = value.m_VerticalFieldOfViewStopAngle;
					m_UpdateRate = value.m_UpdateRate;
					m_MinimumRange = value.m_MinimumRange;
					m_MaximumRange = value.m_MaximumRange;
					m_SensorState = value.m_SensorState;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<RangeSensorConfigurationRec> m_RangeSensorConfigurationRec;
		
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
				return (long) m_RangeSensorConfigurationRec.size();
			}
			
			public ReportRangeSensorConfiguration.Body.RangeSensorConfigurationList.RangeSensorConfigurationRec getElement(int index)
			{
				return m_RangeSensorConfigurationRec.get(index);
			}
			
			public void setElement(int index, RangeSensorConfigurationRec value)
			{
				if(m_RangeSensorConfigurationRec.size()-1 < index)
				{
					return;
				}
				
				m_RangeSensorConfigurationRec.set(index, value);
				m_RangeSensorConfigurationRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(RangeSensorConfigurationRec value)
			{
				m_RangeSensorConfigurationRec.add(value);
				m_RangeSensorConfigurationRec.get(m_RangeSensorConfigurationRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_RangeSensorConfigurationRec.size()-1 < index)
				{
					return 1;
				}
				
				m_RangeSensorConfigurationRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_RangeSensorConfigurationRec.remove(m_RangeSensorConfigurationRec.size()-1);
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
				for (int i = 0; i < m_RangeSensorConfigurationRec.size(); i++)
				{
					size += m_RangeSensorConfigurationRec.get(i).getSize();
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
				
				int size = (int) m_RangeSensorConfigurationRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_RangeSensorConfigurationRec.size(); i++)
				{
					m_RangeSensorConfigurationRec.get(i).encode(bytes, pos);
					pos += m_RangeSensorConfigurationRec.get(i).getSize();
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
				m_RangeSensorConfigurationRec = new ArrayList<RangeSensorConfigurationRec>();
				for (int i = 0; i <  size; i++)
				{
					RangeSensorConfigurationRec item = new RangeSensorConfigurationRec();
					item.decode(bytes, pos);
					m_RangeSensorConfigurationRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportRangeSensorConfiguration.Body.RangeSensorConfigurationList assign(RangeSensorConfigurationList value)
			{
				m_RangeSensorConfigurationRec.clear();
				
				for (int i = 0; i < value.m_RangeSensorConfigurationRec.size(); i++)
				{
					m_RangeSensorConfigurationRec.add(value.m_RangeSensorConfigurationRec.get(i));
					m_RangeSensorConfigurationRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(RangeSensorConfigurationList value)
			{
				for (int i = 0; i < m_RangeSensorConfigurationRec.size(); i++)
				{
					if (!m_RangeSensorConfigurationRec.get(i).isEqual(value.getElement(i)))
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
				m_RangeSensorConfigurationRec = new ArrayList<RangeSensorConfigurationRec>();
				for (int i = 0; i < m_RangeSensorConfigurationRec.size(); i++)
				{
					m_RangeSensorConfigurationRec.get(i).setParent(this);
				}
			}
			
			public RangeSensorConfigurationList(RangeSensorConfigurationList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_RangeSensorConfigurationRec = new ArrayList<RangeSensorConfigurationRec>();
				for (int i = 0; i < m_RangeSensorConfigurationRec.size(); i++)
				{
					m_RangeSensorConfigurationRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_RangeSensorConfigurationRec.clear();
				
				for (int i = 0; i < value.m_RangeSensorConfigurationRec.size(); i++)
				{
					m_RangeSensorConfigurationRec.add(value.m_RangeSensorConfigurationRec.get(i));
					m_RangeSensorConfigurationRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected RangeSensorConfigurationList m_RangeSensorConfigurationList;
	
		public ReportRangeSensorConfiguration.Body.RangeSensorConfigurationList getRangeSensorConfigurationList()
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
		
		public ReportRangeSensorConfiguration.Body assign(Body value)
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
	public ReportRangeSensorConfiguration.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportRangeSensorConfiguration.Body getBody()
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
	
	public ReportRangeSensorConfiguration setAs(ReportRangeSensorConfiguration value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportRangeSensorConfiguration value)
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
	
	public boolean notEquals(ReportRangeSensorConfiguration value)
	{
		return !isEqual(value);
	}
	
	public ReportRangeSensorConfiguration()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportRangeSensorConfiguration(ReportRangeSensorConfiguration value)
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
