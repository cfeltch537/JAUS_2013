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

public class ReportSensorGeometricProperties extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4805;
	
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
			
			public ReportSensorGeometricProperties.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4805;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4805;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportSensorGeometricProperties.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportSensorGeometricProperties.AppHeader assign(AppHeader value)
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
		public static class  GeometricPropertiesList
		{
			public static class  GeometricPropertiesSequence
			{
				public static class  SensorIdRec
				{
				
					protected GeometricPropertiesSequence m_parent;
					protected int m_SensorID;
				
					public void setParent(GeometricPropertiesSequence parent)
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
					
					public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.SensorIdRec assign(SensorIdRec value)
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
				public static class  GeometricPropertiesVariant
				{
					public static class  NoGeometricPropertiesVariant
					{
					
						protected GeometricPropertiesVariant m_parent;
						protected short m_FieldValue;
					
						public void setParent(GeometricPropertiesVariant parent)
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
						
						public short getFieldValue()
						{
							return m_FieldValue;
						}
						
						public void setFieldValue(short fieldValue)
						{
							if(fieldValue > 0)
							{
								return;
							}
							
							m_FieldValue = fieldValue;
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
							
							switch(m_FieldValue)
							{
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
							bytes.put(pos, (byte) m_FieldValue);
							pos += JausUtils.getNumBytes("byte");
							}
							catch (Exception e)
							{
								logger.log(Level.SEVERE, null, e);
							}
							
							switch(m_FieldValue)
							{
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
							m_FieldValue = (short) (bytes.get(pos) & 0xff);
							pos += JausUtils.getNumBytes("byte");
							}
							catch (Exception e)
							{
								logger.log(Level.SEVERE, null, e);
							}
							
							switch(m_FieldValue)
							{
							}
						}
						
						public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.NoGeometricPropertiesVariant assign(NoGeometricPropertiesVariant value)
						{
							m_FieldValue = value.m_FieldValue;
							
							return this;
						}
						
						public boolean isEqual(NoGeometricPropertiesVariant value)
						{
							if (m_FieldValue != value.m_FieldValue)
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(NoGeometricPropertiesVariant value)
						{
							return !this.isEqual(value);
						}
						
						public NoGeometricPropertiesVariant()
						{
							m_parent = null;
						}
						
						public NoGeometricPropertiesVariant(NoGeometricPropertiesVariant value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							
							/// Copy the values
							m_FieldValue = value.m_FieldValue;
						}
						
						public void finalize()
						{
						}
						
					}
					public static class  StaticGeometricPropertiesRec
					{
						public static class  SensorPosition
						{
						
							protected StaticGeometricPropertiesRec m_parent;
							int m_PositionVectorDimensionSize;
							protected long[] m_PositionVectorElement = new long[3];
						
							public void setParent(StaticGeometricPropertiesRec parent)
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
							
							public int getPositionVectorDimensionSize()
							{
								return m_PositionVectorDimensionSize;
							}
							
							public double getPositionVectorElement(int PositionVectorDimension)
							{
								double value;
								int index = PositionVectorDimension;
								
								double scaleFactor = ( 30.0 - -30.0 ) / 4.294967295E9;
								double bias = -30.0;
								
								value = m_PositionVectorElement[index] * scaleFactor + bias;
								
								return value;
							}
							
							public void setPositionVectorElement(int PositionVectorDimension, double value)
							{
								if ((value >= -30.0) && (value <= 30.0))
								{
									int index = PositionVectorDimension;
									
									double scaleFactor = ( 30.0 - -30.0 ) / 4.294967295E9;
									double bias = -30.0;
									
									m_PositionVectorElement[index]= (long)((value - bias) / scaleFactor);
									setParentPresenceVector();
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
								
								size += JausUtils.getNumBytes("int") * 3;
								
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
								
								
								for (int i = 0; i < 3; i++)
								{
								bytes.putInt(pos, (int) m_PositionVectorElement[i]);
								pos += JausUtils.getNumBytes("int");
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
									for (int i = 0; i < 3; i++)
									{
								m_PositionVectorElement[i] = bytes.getInt(pos) & 0xffffffffL;
								pos += JausUtils.getNumBytes("int");
									}
								}
								catch(Exception e)
								{
									logger.log(Level.SEVERE, null, e);
								}
							}
							
							public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.StaticGeometricPropertiesRec.SensorPosition assign(SensorPosition value)
							{
								m_PositionVectorElement = value.m_PositionVectorElement;
								
								return this;
							}
							
							public boolean isEqual(SensorPosition value)
							{
								if(!java.util.Arrays.equals(m_PositionVectorElement, value.m_PositionVectorElement))
								{
									return false;
								}
								
								return true;
							}
							
							public boolean notEquals(SensorPosition value)
							{
								return !this.isEqual(value);
							}
							
							public SensorPosition()
							{
								m_parent = null;
								m_PositionVectorDimensionSize = 3;
							}
							
							public SensorPosition(SensorPosition value)
							{
								/// Initiliaze the protected variables
								m_parent = null;
								m_PositionVectorDimensionSize = 3;
								
								/// Copy the values
								m_PositionVectorElement = value.m_PositionVectorElement;
							}
							
							public void finalize()
							{
							}
							
						}
						public static class  UnitQuaternion
						{
						
							protected StaticGeometricPropertiesRec m_parent;
							int m_UnitQuaternionDimensionSize;
							protected long[] m_UnitQuaternionElement = new long[4];
						
							public void setParent(StaticGeometricPropertiesRec parent)
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
							
							public int getUnitQuaternionDimensionSize()
							{
								return m_UnitQuaternionDimensionSize;
							}
							
							public double getUnitQuaternionElement(int UnitQuaternionDimension)
							{
								double value;
								int index = UnitQuaternionDimension;
								
								double scaleFactor = ( 1.0 - -1.0 ) / 4.294967295E9;
								double bias = -1.0;
								
								value = m_UnitQuaternionElement[index] * scaleFactor + bias;
								
								return value;
							}
							
							public void setUnitQuaternionElement(int UnitQuaternionDimension, double value)
							{
								if ((value >= -1.0) && (value <= 1.0))
								{
									int index = UnitQuaternionDimension;
									
									double scaleFactor = ( 1.0 - -1.0 ) / 4.294967295E9;
									double bias = -1.0;
									
									m_UnitQuaternionElement[index]= (long)((value - bias) / scaleFactor);
									setParentPresenceVector();
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
								
								size += JausUtils.getNumBytes("int") * 4;
								
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
								
								
								for (int i = 0; i < 4; i++)
								{
								bytes.putInt(pos, (int) m_UnitQuaternionElement[i]);
								pos += JausUtils.getNumBytes("int");
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
									for (int i = 0; i < 4; i++)
									{
								m_UnitQuaternionElement[i] = bytes.getInt(pos) & 0xffffffffL;
								pos += JausUtils.getNumBytes("int");
									}
								}
								catch(Exception e)
								{
									logger.log(Level.SEVERE, null, e);
								}
							}
							
							public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.StaticGeometricPropertiesRec.UnitQuaternion assign(UnitQuaternion value)
							{
								m_UnitQuaternionElement = value.m_UnitQuaternionElement;
								
								return this;
							}
							
							public boolean isEqual(UnitQuaternion value)
							{
								if(!java.util.Arrays.equals(m_UnitQuaternionElement, value.m_UnitQuaternionElement))
								{
									return false;
								}
								
								return true;
							}
							
							public boolean notEquals(UnitQuaternion value)
							{
								return !this.isEqual(value);
							}
							
							public UnitQuaternion()
							{
								m_parent = null;
								m_UnitQuaternionDimensionSize = 4;
							}
							
							public UnitQuaternion(UnitQuaternion value)
							{
								/// Initiliaze the protected variables
								m_parent = null;
								m_UnitQuaternionDimensionSize = 4;
								
								/// Copy the values
								m_UnitQuaternionElement = value.m_UnitQuaternionElement;
							}
							
							public void finalize()
							{
							}
							
						}
					
					
						protected GeometricPropertiesVariant m_parent;
						protected SensorPosition m_SensorPosition;
						protected UnitQuaternion m_UnitQuaternion;
					
						public void setParent(GeometricPropertiesVariant parent)
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
						
						public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.StaticGeometricPropertiesRec.SensorPosition getSensorPosition()
						{
							return m_SensorPosition;
						}
						
						public void setSensorPosition(SensorPosition value)
						{
							m_SensorPosition = value;
							setParentPresenceVector();
						}
						
						public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.StaticGeometricPropertiesRec.UnitQuaternion getUnitQuaternion()
						{
							return m_UnitQuaternion;
						}
						
						public void setUnitQuaternion(UnitQuaternion value)
						{
							m_UnitQuaternion = value;
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
							
							size += m_SensorPosition.getSize();
							size += m_UnitQuaternion.getSize();
							
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
							
							m_SensorPosition.encode(bytes, pos);
							pos += m_SensorPosition.getSize();
							m_UnitQuaternion.encode(bytes, pos);
							pos += m_UnitQuaternion.getSize();
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
							
							m_SensorPosition.decode(bytes, pos);
							pos += m_SensorPosition.getSize();
							m_UnitQuaternion.decode(bytes, pos);
							pos += m_UnitQuaternion.getSize();
						}
						
						public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.StaticGeometricPropertiesRec assign(StaticGeometricPropertiesRec value)
						{
							m_SensorPosition = value.m_SensorPosition;
							m_UnitQuaternion = value.m_UnitQuaternion;
							
							return this;
						}
						
						public boolean isEqual(StaticGeometricPropertiesRec value)
						{
							if (!m_SensorPosition.isEqual(value.getSensorPosition()))
							{
								return false;
							}
							
							if (!m_UnitQuaternion.isEqual(value.getUnitQuaternion()))
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(StaticGeometricPropertiesRec value)
						{
							return !this.isEqual(value);
						}
						
						public StaticGeometricPropertiesRec()
						{
							m_parent = null;
							m_SensorPosition = new SensorPosition();
							m_SensorPosition.setParent(this);
							m_UnitQuaternion = new UnitQuaternion();
							m_UnitQuaternion.setParent(this);
						}
						
						public StaticGeometricPropertiesRec(StaticGeometricPropertiesRec value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_SensorPosition = new SensorPosition();
							m_SensorPosition.setParent(this);
							m_UnitQuaternion = new UnitQuaternion();
							m_UnitQuaternion.setParent(this);
							
							/// Copy the values
							m_SensorPosition = value.m_SensorPosition;
							m_UnitQuaternion = value.m_UnitQuaternion;
						}
						
						public void finalize()
						{
						}
						
					}
					public static class  ManipulatorGeometricPropertiesRec
					{
						public static class  SensorPosition
						{
						
							protected ManipulatorGeometricPropertiesRec m_parent;
							int m_PositionVectorDimensionSize;
							protected long[] m_PositionVectorElement = new long[3];
						
							public void setParent(ManipulatorGeometricPropertiesRec parent)
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
							
							public int getPositionVectorDimensionSize()
							{
								return m_PositionVectorDimensionSize;
							}
							
							public double getPositionVectorElement(int PositionVectorDimension)
							{
								double value;
								int index = PositionVectorDimension;
								
								double scaleFactor = ( 30.0 - -30.0 ) / 4.294967295E9;
								double bias = -30.0;
								
								value = m_PositionVectorElement[index] * scaleFactor + bias;
								
								return value;
							}
							
							public void setPositionVectorElement(int PositionVectorDimension, double value)
							{
								if ((value >= -30.0) && (value <= 30.0))
								{
									int index = PositionVectorDimension;
									
									double scaleFactor = ( 30.0 - -30.0 ) / 4.294967295E9;
									double bias = -30.0;
									
									m_PositionVectorElement[index]= (long)((value - bias) / scaleFactor);
									setParentPresenceVector();
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
								
								size += JausUtils.getNumBytes("int") * 3;
								
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
								
								
								for (int i = 0; i < 3; i++)
								{
								bytes.putInt(pos, (int) m_PositionVectorElement[i]);
								pos += JausUtils.getNumBytes("int");
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
									for (int i = 0; i < 3; i++)
									{
								m_PositionVectorElement[i] = bytes.getInt(pos) & 0xffffffffL;
								pos += JausUtils.getNumBytes("int");
									}
								}
								catch(Exception e)
								{
									logger.log(Level.SEVERE, null, e);
								}
							}
							
							public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.ManipulatorGeometricPropertiesRec.SensorPosition assign(SensorPosition value)
							{
								m_PositionVectorElement = value.m_PositionVectorElement;
								
								return this;
							}
							
							public boolean isEqual(SensorPosition value)
							{
								if(!java.util.Arrays.equals(m_PositionVectorElement, value.m_PositionVectorElement))
								{
									return false;
								}
								
								return true;
							}
							
							public boolean notEquals(SensorPosition value)
							{
								return !this.isEqual(value);
							}
							
							public SensorPosition()
							{
								m_parent = null;
								m_PositionVectorDimensionSize = 3;
							}
							
							public SensorPosition(SensorPosition value)
							{
								/// Initiliaze the protected variables
								m_parent = null;
								m_PositionVectorDimensionSize = 3;
								
								/// Copy the values
								m_PositionVectorElement = value.m_PositionVectorElement;
							}
							
							public void finalize()
							{
							}
							
						}
						public static class  UnitQuaternion
						{
						
							protected ManipulatorGeometricPropertiesRec m_parent;
							int m_UnitQuaternionDimensionSize;
							protected long[] m_UnitQuaternionElement = new long[4];
						
							public void setParent(ManipulatorGeometricPropertiesRec parent)
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
							
							public int getUnitQuaternionDimensionSize()
							{
								return m_UnitQuaternionDimensionSize;
							}
							
							public double getUnitQuaternionElement(int UnitQuaternionDimension)
							{
								double value;
								int index = UnitQuaternionDimension;
								
								double scaleFactor = ( 1.0 - -1.0 ) / 4.294967295E9;
								double bias = -1.0;
								
								value = m_UnitQuaternionElement[index] * scaleFactor + bias;
								
								return value;
							}
							
							public void setUnitQuaternionElement(int UnitQuaternionDimension, double value)
							{
								if ((value >= -1.0) && (value <= 1.0))
								{
									int index = UnitQuaternionDimension;
									
									double scaleFactor = ( 1.0 - -1.0 ) / 4.294967295E9;
									double bias = -1.0;
									
									m_UnitQuaternionElement[index]= (long)((value - bias) / scaleFactor);
									setParentPresenceVector();
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
								
								size += JausUtils.getNumBytes("int") * 4;
								
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
								
								
								for (int i = 0; i < 4; i++)
								{
								bytes.putInt(pos, (int) m_UnitQuaternionElement[i]);
								pos += JausUtils.getNumBytes("int");
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
									for (int i = 0; i < 4; i++)
									{
								m_UnitQuaternionElement[i] = bytes.getInt(pos) & 0xffffffffL;
								pos += JausUtils.getNumBytes("int");
									}
								}
								catch(Exception e)
								{
									logger.log(Level.SEVERE, null, e);
								}
							}
							
							public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.ManipulatorGeometricPropertiesRec.UnitQuaternion assign(UnitQuaternion value)
							{
								m_UnitQuaternionElement = value.m_UnitQuaternionElement;
								
								return this;
							}
							
							public boolean isEqual(UnitQuaternion value)
							{
								if(!java.util.Arrays.equals(m_UnitQuaternionElement, value.m_UnitQuaternionElement))
								{
									return false;
								}
								
								return true;
							}
							
							public boolean notEquals(UnitQuaternion value)
							{
								return !this.isEqual(value);
							}
							
							public UnitQuaternion()
							{
								m_parent = null;
								m_UnitQuaternionDimensionSize = 4;
							}
							
							public UnitQuaternion(UnitQuaternion value)
							{
								/// Initiliaze the protected variables
								m_parent = null;
								m_UnitQuaternionDimensionSize = 4;
								
								/// Copy the values
								m_UnitQuaternionElement = value.m_UnitQuaternionElement;
							}
							
							public void finalize()
							{
							}
							
						}
					
					
						protected GeometricPropertiesVariant m_parent;
						protected int m_SubsystemID;
						protected short m_NodeID;
						protected short m_ComponentID;
						protected short m_JointNumber;
						protected SensorPosition m_SensorPosition;
						protected UnitQuaternion m_UnitQuaternion;
					
						public void setParent(GeometricPropertiesVariant parent)
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
						
						public int getSubsystemID()
						{
							return m_SubsystemID;
						}
						
						public void setSubsystemID(int value)
						{
							m_SubsystemID = value;
							setParentPresenceVector();
						}
						
						public short getNodeID()
						{
							return m_NodeID;
						}
						
						public void setNodeID(short value)
						{
							m_NodeID = value;
							setParentPresenceVector();
						}
						
						public short getComponentID()
						{
							return m_ComponentID;
						}
						
						public void setComponentID(short value)
						{
							m_ComponentID = value;
							setParentPresenceVector();
						}
						
						public short getJointNumber()
						{
							return m_JointNumber;
						}
						
						public void setJointNumber(short value)
						{
							m_JointNumber = value;
							setParentPresenceVector();
						}
						
						public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.ManipulatorGeometricPropertiesRec.SensorPosition getSensorPosition()
						{
							return m_SensorPosition;
						}
						
						public void setSensorPosition(SensorPosition value)
						{
							m_SensorPosition = value;
							setParentPresenceVector();
						}
						
						public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.ManipulatorGeometricPropertiesRec.UnitQuaternion getUnitQuaternion()
						{
							return m_UnitQuaternion;
						}
						
						public void setUnitQuaternion(UnitQuaternion value)
						{
							m_UnitQuaternion = value;
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
							size += JausUtils.getNumBytes("byte");
							size += JausUtils.getNumBytes("byte");
							size += m_SensorPosition.getSize();
							size += m_UnitQuaternion.getSize();
							
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
							
							bytes.putShort(pos, (short) m_SubsystemID);
							pos += JausUtils.getNumBytes("short");
							bytes.put(pos, (byte) m_NodeID);
							pos += JausUtils.getNumBytes("byte");
							bytes.put(pos, (byte) m_ComponentID);
							pos += JausUtils.getNumBytes("byte");
							bytes.put(pos, (byte) m_JointNumber);
							pos += JausUtils.getNumBytes("byte");
							m_SensorPosition.encode(bytes, pos);
							pos += m_SensorPosition.getSize();
							m_UnitQuaternion.encode(bytes, pos);
							pos += m_UnitQuaternion.getSize();
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
							
							m_SubsystemID = bytes.getShort(pos) & 0xffff;
							pos += JausUtils.getNumBytes("short");
							m_NodeID = (short) (bytes.get(pos) & 0xff);
							pos += JausUtils.getNumBytes("byte");
							m_ComponentID = (short) (bytes.get(pos) & 0xff);
							pos += JausUtils.getNumBytes("byte");
							m_JointNumber = (short) (bytes.get(pos) & 0xff);
							pos += JausUtils.getNumBytes("byte");
							m_SensorPosition.decode(bytes, pos);
							pos += m_SensorPosition.getSize();
							m_UnitQuaternion.decode(bytes, pos);
							pos += m_UnitQuaternion.getSize();
						}
						
						public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.ManipulatorGeometricPropertiesRec assign(ManipulatorGeometricPropertiesRec value)
						{
							m_SubsystemID = value.m_SubsystemID;
							m_NodeID = value.m_NodeID;
							m_ComponentID = value.m_ComponentID;
							m_JointNumber = value.m_JointNumber;
							m_SensorPosition = value.m_SensorPosition;
							m_UnitQuaternion = value.m_UnitQuaternion;
							
							return this;
						}
						
						public boolean isEqual(ManipulatorGeometricPropertiesRec value)
						{
							if (m_SubsystemID != value.getSubsystemID())
							{
								return false;
							}
							if (m_NodeID != value.getNodeID())
							{
								return false;
							}
							if (m_ComponentID != value.getComponentID())
							{
								return false;
							}
							if (m_JointNumber != value.getJointNumber())
							{
								return false;
							}
							
							if (!m_SensorPosition.isEqual(value.getSensorPosition()))
							{
								return false;
							}
							
							if (!m_UnitQuaternion.isEqual(value.getUnitQuaternion()))
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(ManipulatorGeometricPropertiesRec value)
						{
							return !this.isEqual(value);
						}
						
						public ManipulatorGeometricPropertiesRec()
						{
							m_parent = null;
							m_SubsystemID = 0;
							m_NodeID = 0;
							m_ComponentID = 0;
							m_JointNumber = 0;
							m_SensorPosition = new SensorPosition();
							m_SensorPosition.setParent(this);
							m_UnitQuaternion = new UnitQuaternion();
							m_UnitQuaternion.setParent(this);
						}
						
						public ManipulatorGeometricPropertiesRec(ManipulatorGeometricPropertiesRec value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_SubsystemID = 0;
							m_NodeID = 0;
							m_ComponentID = 0;
							m_JointNumber = 0;
							m_SensorPosition = new SensorPosition();
							m_SensorPosition.setParent(this);
							m_UnitQuaternion = new UnitQuaternion();
							m_UnitQuaternion.setParent(this);
							
							/// Copy the values
							m_SubsystemID = value.m_SubsystemID;
							m_NodeID = value.m_NodeID;
							m_ComponentID = value.m_ComponentID;
							m_JointNumber = value.m_JointNumber;
							m_SensorPosition = value.m_SensorPosition;
							m_UnitQuaternion = value.m_UnitQuaternion;
						}
						
						public void finalize()
						{
						}
						
					}
				
				
					protected GeometricPropertiesSequence m_parent;
					protected short m_FieldValue;
					protected NoGeometricPropertiesVariant m_NoGeometricPropertiesVariant;
					protected StaticGeometricPropertiesRec m_StaticGeometricPropertiesRec;
					protected ManipulatorGeometricPropertiesRec m_ManipulatorGeometricPropertiesRec;
				
					public void setParent(GeometricPropertiesSequence parent)
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
					
					public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.NoGeometricPropertiesVariant getNoGeometricPropertiesVariant()
					{
						return m_NoGeometricPropertiesVariant;
					}
					
					public void setNoGeometricPropertiesVariant(NoGeometricPropertiesVariant value)
					{
						m_NoGeometricPropertiesVariant = value;
						setParentPresenceVector();
					}
					
					public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.StaticGeometricPropertiesRec getStaticGeometricPropertiesRec()
					{
						return m_StaticGeometricPropertiesRec;
					}
					
					public void setStaticGeometricPropertiesRec(StaticGeometricPropertiesRec value)
					{
						m_StaticGeometricPropertiesRec = value;
						setParentPresenceVector();
					}
					
					public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant.ManipulatorGeometricPropertiesRec getManipulatorGeometricPropertiesRec()
					{
						return m_ManipulatorGeometricPropertiesRec;
					}
					
					public void setManipulatorGeometricPropertiesRec(ManipulatorGeometricPropertiesRec value)
					{
						m_ManipulatorGeometricPropertiesRec = value;
						setParentPresenceVector();
					}
					
					public short getFieldValue()
					{
						return m_FieldValue;
					}
					
					public void setFieldValue(short fieldValue)
					{
						if(fieldValue > 2)
						{
							return;
						}
						
						m_FieldValue = fieldValue;
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
						
						switch(m_FieldValue)
						{
							case 0:
								size += m_NoGeometricPropertiesVariant.getSize();
								break;
							case 1:
								size += m_StaticGeometricPropertiesRec.getSize();
								break;
							case 2:
								size += m_ManipulatorGeometricPropertiesRec.getSize();
								break;
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
						bytes.put(pos, (byte) m_FieldValue);
						pos += JausUtils.getNumBytes("byte");
						}
						catch (Exception e)
						{
							logger.log(Level.SEVERE, null, e);
						}
						
						switch(m_FieldValue)
						{
							case 0:
								m_NoGeometricPropertiesVariant.encode(bytes, pos);
								pos += m_NoGeometricPropertiesVariant.getSize();
								break;
							case 1:
								m_StaticGeometricPropertiesRec.encode(bytes, pos);
								pos += m_StaticGeometricPropertiesRec.getSize();
								break;
							case 2:
								m_ManipulatorGeometricPropertiesRec.encode(bytes, pos);
								pos += m_ManipulatorGeometricPropertiesRec.getSize();
								break;
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
						m_FieldValue = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
						}
						catch (Exception e)
						{
							logger.log(Level.SEVERE, null, e);
						}
						
						switch(m_FieldValue)
						{
							case 0:
								m_NoGeometricPropertiesVariant.decode(bytes, pos);
								pos += m_NoGeometricPropertiesVariant.getSize();
								break;
							case 1:
								m_StaticGeometricPropertiesRec.decode(bytes, pos);
								pos += m_StaticGeometricPropertiesRec.getSize();
								break;
							case 2:
								m_ManipulatorGeometricPropertiesRec.decode(bytes, pos);
								pos += m_ManipulatorGeometricPropertiesRec.getSize();
								break;
						}
					}
					
					public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant assign(GeometricPropertiesVariant value)
					{
						m_FieldValue = value.m_FieldValue;
						m_NoGeometricPropertiesVariant = value.m_NoGeometricPropertiesVariant;
						m_NoGeometricPropertiesVariant.setParent(this);
						m_StaticGeometricPropertiesRec = value.m_StaticGeometricPropertiesRec;
						m_StaticGeometricPropertiesRec.setParent(this);
						m_ManipulatorGeometricPropertiesRec = value.m_ManipulatorGeometricPropertiesRec;
						m_ManipulatorGeometricPropertiesRec.setParent(this);
						
						return this;
					}
					
					public boolean isEqual(GeometricPropertiesVariant value)
					{
						if (m_FieldValue != value.m_FieldValue)
						{
							return false;
						}
						if (!m_NoGeometricPropertiesVariant.isEqual(value.m_NoGeometricPropertiesVariant))
						{
							return false;
						}
						if (!m_StaticGeometricPropertiesRec.isEqual(value.getStaticGeometricPropertiesRec()))
						{
							return false;
						}
						if (!m_ManipulatorGeometricPropertiesRec.isEqual(value.getManipulatorGeometricPropertiesRec()))
						{
							return false;
						}
						
						return true;
					}
					
					public boolean notEquals(GeometricPropertiesVariant value)
					{
						return !this.isEqual(value);
					}
					
					public GeometricPropertiesVariant()
					{
						m_parent = null;
						m_NoGeometricPropertiesVariant = new NoGeometricPropertiesVariant();
						m_NoGeometricPropertiesVariant.setParent(this);
						m_StaticGeometricPropertiesRec = new StaticGeometricPropertiesRec();
						m_StaticGeometricPropertiesRec.setParent(this);
						m_ManipulatorGeometricPropertiesRec = new ManipulatorGeometricPropertiesRec();
						m_ManipulatorGeometricPropertiesRec.setParent(this);
					}
					
					public GeometricPropertiesVariant(GeometricPropertiesVariant value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_NoGeometricPropertiesVariant = new NoGeometricPropertiesVariant();
						m_NoGeometricPropertiesVariant.setParent(this);
						m_StaticGeometricPropertiesRec = new StaticGeometricPropertiesRec();
						m_StaticGeometricPropertiesRec.setParent(this);
						m_ManipulatorGeometricPropertiesRec = new ManipulatorGeometricPropertiesRec();
						m_ManipulatorGeometricPropertiesRec.setParent(this);
						
						/// Copy the values
						m_FieldValue = value.m_FieldValue;
						m_NoGeometricPropertiesVariant = value.m_NoGeometricPropertiesVariant;
						m_NoGeometricPropertiesVariant.setParent(this);
						m_StaticGeometricPropertiesRec = value.m_StaticGeometricPropertiesRec;
						m_StaticGeometricPropertiesRec.setParent(this);
						m_ManipulatorGeometricPropertiesRec = value.m_ManipulatorGeometricPropertiesRec;
						m_ManipulatorGeometricPropertiesRec.setParent(this);
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected GeometricPropertiesList m_parent;
				protected SensorIdRec m_SensorIdRec;
				protected GeometricPropertiesVariant m_GeometricPropertiesVariant;
			
				public void setParent(GeometricPropertiesList parent)
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
				
				public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.SensorIdRec getSensorIdRec()
				{
					return m_SensorIdRec;
				}
				
				public void setSensorIdRec(SensorIdRec value)
				{
					m_SensorIdRec = value;
					setParentPresenceVector();
				}
				
				public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence.GeometricPropertiesVariant getGeometricPropertiesVariant()
				{
					return m_GeometricPropertiesVariant;
				}
				
				public void setGeometricPropertiesVariant(GeometricPropertiesVariant value)
				{
					m_GeometricPropertiesVariant = value;
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
					
					size += m_SensorIdRec.getSize();
					size += m_GeometricPropertiesVariant.getSize();
					
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
					
					m_SensorIdRec.encode(bytes, pos);
					pos += m_SensorIdRec.getSize();
					m_GeometricPropertiesVariant.encode(bytes, pos);
					pos += m_GeometricPropertiesVariant.getSize();
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
					
					m_SensorIdRec.decode(bytes, pos);
					pos += m_SensorIdRec.getSize();
					m_GeometricPropertiesVariant.decode(bytes, pos);
					pos += m_GeometricPropertiesVariant.getSize();
				}
				
				public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence assign(GeometricPropertiesSequence value)
				{
					m_SensorIdRec = value.m_SensorIdRec;
					m_SensorIdRec.setParent(this);
					m_SensorIdRec = value.m_SensorIdRec;
					m_GeometricPropertiesVariant = value.m_GeometricPropertiesVariant;
					m_GeometricPropertiesVariant.setParent(this);
					m_GeometricPropertiesVariant = value.m_GeometricPropertiesVariant;
					
					return this;
				}
				
				public boolean isEqual(GeometricPropertiesSequence value)
				{
					if (!m_SensorIdRec.isEqual(value.getSensorIdRec()))
					{
						return false;
					}
					
					if (!m_SensorIdRec.isEqual(value.getSensorIdRec()))
					{
						return false;
					}
					if (!m_GeometricPropertiesVariant.isEqual(value.m_GeometricPropertiesVariant))
					{
						return false;
					}
					
					if (!m_GeometricPropertiesVariant.isEqual(value.getGeometricPropertiesVariant()))
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(GeometricPropertiesSequence value)
				{
					return !this.isEqual(value);
				}
				
				public GeometricPropertiesSequence()
				{
					m_parent = null;
					m_SensorIdRec = new SensorIdRec();
					m_SensorIdRec.setParent(this);
					m_GeometricPropertiesVariant = new GeometricPropertiesVariant();
					m_GeometricPropertiesVariant.setParent(this);
				}
				
				public GeometricPropertiesSequence(GeometricPropertiesSequence value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_SensorIdRec = new SensorIdRec();
					m_SensorIdRec.setParent(this);
					m_GeometricPropertiesVariant = new GeometricPropertiesVariant();
					m_GeometricPropertiesVariant.setParent(this);
					
					/// Copy the values
					m_SensorIdRec = value.m_SensorIdRec;
					m_SensorIdRec.setParent(this);
					m_SensorIdRec = value.m_SensorIdRec;
					m_GeometricPropertiesVariant = value.m_GeometricPropertiesVariant;
					m_GeometricPropertiesVariant.setParent(this);
					m_GeometricPropertiesVariant = value.m_GeometricPropertiesVariant;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<GeometricPropertiesSequence> m_GeometricPropertiesSequence;
		
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
			
			public int getNumberOfElements()
			{
				return m_GeometricPropertiesSequence.size();
			}
			
			public ReportSensorGeometricProperties.Body.GeometricPropertiesList.GeometricPropertiesSequence getElement(int index)
			{
				return m_GeometricPropertiesSequence.get(index);
			}
			
			public void setElement(int index, GeometricPropertiesSequence value)
			{
				if(m_GeometricPropertiesSequence.size()-1 < index)
				{
					return;
				}
				
				m_GeometricPropertiesSequence.set(index, value);
				m_GeometricPropertiesSequence.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(GeometricPropertiesSequence value)
			{
				m_GeometricPropertiesSequence.add(value);
				m_GeometricPropertiesSequence.get(m_GeometricPropertiesSequence.size() -1).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_GeometricPropertiesSequence.size()-1 < index)
				{
					return 1;
				}
				
				m_GeometricPropertiesSequence.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_GeometricPropertiesSequence.remove(m_GeometricPropertiesSequence.size() -1);
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
				for (int i = 0; i < m_GeometricPropertiesSequence.size(); i++)
				{
					size += m_GeometricPropertiesSequence.get(i).getSize();
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
				
				int size = (int) m_GeometricPropertiesSequence.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_GeometricPropertiesSequence.size(); i++)
				{
					m_GeometricPropertiesSequence.get(i).encode(bytes, pos);
					pos += m_GeometricPropertiesSequence.get(i).getSize();
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
				m_GeometricPropertiesSequence = new ArrayList<GeometricPropertiesSequence>();
				for (int i = 0; i <  size; i++)
				{
					GeometricPropertiesSequence item = new GeometricPropertiesSequence();
					item.decode(bytes, pos);
					m_GeometricPropertiesSequence.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportSensorGeometricProperties.Body.GeometricPropertiesList assign(GeometricPropertiesList value)
			{
				m_GeometricPropertiesSequence.clear();
				
				for (int i = 0; i < value.m_GeometricPropertiesSequence.size(); i++)
				{
					m_GeometricPropertiesSequence.add(value.m_GeometricPropertiesSequence.get(i));
					m_GeometricPropertiesSequence.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(GeometricPropertiesList value)
			{
				for (int i = 0; i < m_GeometricPropertiesSequence.size(); i++)
				{
					if (!m_GeometricPropertiesSequence.get(i).isEqual(value.m_GeometricPropertiesSequence.get(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(GeometricPropertiesList value)
			{
				return !this.isEqual(value);
			}
			
			public GeometricPropertiesList()
			{
				m_parent = null;
				m_GeometricPropertiesSequence = new ArrayList<GeometricPropertiesSequence>();
				for (int i = 0; i < m_GeometricPropertiesSequence.size(); i++)
				{
					m_GeometricPropertiesSequence.get(i).setParent(this);
				}
			}
			
			public GeometricPropertiesList(GeometricPropertiesList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_GeometricPropertiesSequence = new ArrayList<GeometricPropertiesSequence>();
				for (int i = 0; i < m_GeometricPropertiesSequence.size(); i++)
				{
					m_GeometricPropertiesSequence.get(i).setParent(this);
				}
				
				/// Copy the values
				m_GeometricPropertiesSequence.clear();
				
				for (int i = 0; i < value.m_GeometricPropertiesSequence.size(); i++)
				{
					m_GeometricPropertiesSequence.add(value.m_GeometricPropertiesSequence.get(i));
					m_GeometricPropertiesSequence.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected GeometricPropertiesList m_GeometricPropertiesList;
	
		public ReportSensorGeometricProperties.Body.GeometricPropertiesList getGeometricPropertiesList()
		{
			return m_GeometricPropertiesList;
		}
		
		public void setGeometricPropertiesList(GeometricPropertiesList value)
		{
			m_GeometricPropertiesList = value;
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
			
			size += m_GeometricPropertiesList.getSize();
			
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
			
			m_GeometricPropertiesList.encode(bytes, pos);
			pos += m_GeometricPropertiesList.getSize();
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
			
			m_GeometricPropertiesList.decode(bytes, pos);
			pos += m_GeometricPropertiesList.getSize();
		}
		
		public ReportSensorGeometricProperties.Body assign(Body value)
		{
			m_GeometricPropertiesList = value.m_GeometricPropertiesList;
			m_GeometricPropertiesList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_GeometricPropertiesList.isEqual(value.m_GeometricPropertiesList))
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
			m_GeometricPropertiesList = new GeometricPropertiesList();
			m_GeometricPropertiesList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_GeometricPropertiesList = new GeometricPropertiesList();
			m_GeometricPropertiesList.setParent(this);
			
			/// Copy the values
			m_GeometricPropertiesList = value.m_GeometricPropertiesList;
			m_GeometricPropertiesList.setParent(this);
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
	public ReportSensorGeometricProperties.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportSensorGeometricProperties.Body getBody()
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
	
	public ReportSensorGeometricProperties setAs(ReportSensorGeometricProperties value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportSensorGeometricProperties value)
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
	
	public boolean notEquals(ReportSensorGeometricProperties value)
	{
		return !isEqual(value);
	}
	
	public ReportSensorGeometricProperties()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportSensorGeometricProperties(ReportSensorGeometricProperties value)
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
