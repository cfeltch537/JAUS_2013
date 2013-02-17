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

public class ReportVisualSensorConfiguration extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4807;
	
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
			
			public ReportVisualSensorConfiguration.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4807;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4807;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportVisualSensorConfiguration.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportVisualSensorConfiguration.AppHeader assign(AppHeader value)
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
		public static class  VisualSensorConfigurationList
		{
			public static class  VisualSensorConfigurationRec
			{
			
				protected VisualSensorConfigurationList m_parent;
				protected BitSet m_PresenceVector;
				protected long m_PresenceVectorTemp;
				protected int m_SensorID;
				protected short m_SensorState;
				protected short m_ZoomMode;
				protected int m_ZoomLevel;
				protected long m_FocalLength;
				protected long m_HorizontalFieldOfView;
				protected long m_VerticalFieldOfView;
				protected short m_FocusMode;
				protected int m_FocusValue;
				protected short m_WhiteBalance;
				protected short m_ImagingMode;
				protected short m_ExposureMode;
				protected short m_MeteringMode;
				protected int m_ShutterSpeed;
				protected int m_Aperture;
				protected short m_LightSensitivity;
				protected short m_ImageStablization;
			
				public void setParent(VisualSensorConfigurationList parent)
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
				
				public long getPresenceVector()
				{
					return m_PresenceVectorTemp;
				}
				
				protected void setPresenceVector(int index)
				{
					
					m_PresenceVector.set(index);
					m_PresenceVectorTemp = (long) JausUtils.getPVInt(m_PresenceVector);
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
				
				public boolean isSensorStateValid()
				{
					if (checkPresenceVector(0))
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
						setPresenceVector(0);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isZoomModeValid()
				{
					if (checkPresenceVector(1))
					{
						return true;
					}
					return false;
				}
				
				public short getZoomMode()
				{
					return m_ZoomMode;
				}
				
				public void setZoomMode(short value)
				{
					if ((value == 0) || (value == 1) || (value == 2) || (value == 3))
					{
						m_ZoomMode = value;
						setPresenceVector(1);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isZoomLevelValid()
				{
					if (checkPresenceVector(2))
					{
						return true;
					}
					return false;
				}
				
				public double getZoomLevel()
				{
					double value;
					
					double scaleFactor = ( 100.0 - 0.0 ) / 65535.0;
					double bias = 0.0;
					
					value = m_ZoomLevel * scaleFactor + bias;
					
					return value;
				}
				
				public void setZoomLevel(double value)
				{
					if ((value >= 0.0) && (value <= 100.0))
					{
						double scaleFactor = ( 100.0 - 0.0 ) / 65535.0;
						double bias = 0.0;
						
						m_ZoomLevel= (int)((value - bias) / scaleFactor);
						setPresenceVector(2);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isFocalLengthValid()
				{
					if (checkPresenceVector(3))
					{
						return true;
					}
					return false;
				}
				
				public double getFocalLength()
				{
					double value;
					
					double scaleFactor = ( 2.0 - 0.0 ) / 4.294967295E9;
					double bias = 0.0;
					
					value = m_FocalLength * scaleFactor + bias;
					
					return value;
				}
				
				public void setFocalLength(double value)
				{
					if ((value >= 0.0) && (value <= 2.0))
					{
						double scaleFactor = ( 2.0 - 0.0 ) / 4.294967295E9;
						double bias = 0.0;
						
						m_FocalLength= (long)((value - bias) / scaleFactor);
						setPresenceVector(3);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isHorizontalFieldOfViewValid()
				{
					if (checkPresenceVector(4))
					{
						return true;
					}
					return false;
				}
				
				public double getHorizontalFieldOfView()
				{
					double value;
					
					double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
					double bias = -3.141592653589793;
					
					value = m_HorizontalFieldOfView * scaleFactor + bias;
					
					return value;
				}
				
				public void setHorizontalFieldOfView(double value)
				{
					if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
					{
						double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
						double bias = -3.141592653589793;
						
						m_HorizontalFieldOfView= (long)((value - bias) / scaleFactor);
						setPresenceVector(4);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isVerticalFieldOfViewValid()
				{
					if (checkPresenceVector(5))
					{
						return true;
					}
					return false;
				}
				
				public double getVerticalFieldOfView()
				{
					double value;
					
					double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
					double bias = -3.141592653589793;
					
					value = m_VerticalFieldOfView * scaleFactor + bias;
					
					return value;
				}
				
				public void setVerticalFieldOfView(double value)
				{
					if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
					{
						double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
						double bias = -3.141592653589793;
						
						m_VerticalFieldOfView= (long)((value - bias) / scaleFactor);
						setPresenceVector(5);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isFocusModeValid()
				{
					if (checkPresenceVector(6))
					{
						return true;
					}
					return false;
				}
				
				public short getFocusMode()
				{
					return m_FocusMode;
				}
				
				public void setFocusMode(short value)
				{
					if ((value == 0) || (value == 1))
					{
						m_FocusMode = value;
						setPresenceVector(6);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isFocusValueValid()
				{
					if (checkPresenceVector(7))
					{
						return true;
					}
					return false;
				}
				
				public double getFocusValue()
				{
					double value;
					
					double scaleFactor = ( 100.0 - 0.0 ) / 65535.0;
					double bias = 0.0;
					
					value = m_FocusValue * scaleFactor + bias;
					
					return value;
				}
				
				public void setFocusValue(double value)
				{
					if ((value >= 0.0) && (value <= 100.0))
					{
						double scaleFactor = ( 100.0 - 0.0 ) / 65535.0;
						double bias = 0.0;
						
						m_FocusValue= (int)((value - bias) / scaleFactor);
						setPresenceVector(7);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isWhiteBalanceValid()
				{
					if (checkPresenceVector(8))
					{
						return true;
					}
					return false;
				}
				
				public short getWhiteBalance()
				{
					return m_WhiteBalance;
				}
				
				public void setWhiteBalance(short value)
				{
					if ((value == 0) || (value == 1) || (value == 2) || (value == 3) || (value == 4) || (value == 5) || (value == 6))
					{
						m_WhiteBalance = value;
						setPresenceVector(8);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isImagingModeValid()
				{
					if (checkPresenceVector(9))
					{
						return true;
					}
					return false;
				}
				
				public short getImagingMode()
				{
					return m_ImagingMode;
				}
				
				public void setImagingMode(short value)
				{
					if ((value == 0) || (value == 1) || (value == 2) || (value == 3))
					{
						m_ImagingMode = value;
						setPresenceVector(9);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isExposureModeValid()
				{
					if (checkPresenceVector(10))
					{
						return true;
					}
					return false;
				}
				
				public short getExposureMode()
				{
					return m_ExposureMode;
				}
				
				public void setExposureMode(short value)
				{
					if ((value == 0) || (value == 1) || (value == 2) || (value == 3))
					{
						m_ExposureMode = value;
						setPresenceVector(10);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMeteringModeValid()
				{
					if (checkPresenceVector(11))
					{
						return true;
					}
					return false;
				}
				
				public short getMeteringMode()
				{
					return m_MeteringMode;
				}
				
				public void setMeteringMode(short value)
				{
					if ((value == 0) || (value == 1) || (value == 2))
					{
						m_MeteringMode = value;
						setPresenceVector(11);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isShutterSpeedValid()
				{
					if (checkPresenceVector(12))
					{
						return true;
					}
					return false;
				}
				
				public double getShutterSpeed()
				{
					double value;
					
					double scaleFactor = ( 60.0 - 0.0 ) / 65535.0;
					double bias = 0.0;
					
					value = m_ShutterSpeed * scaleFactor + bias;
					
					return value;
				}
				
				public void setShutterSpeed(double value)
				{
					if ((value >= 0.0) && (value <= 60.0))
					{
						double scaleFactor = ( 60.0 - 0.0 ) / 65535.0;
						double bias = 0.0;
						
						m_ShutterSpeed= (int)((value - bias) / scaleFactor);
						setPresenceVector(12);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isApertureValid()
				{
					if (checkPresenceVector(13))
					{
						return true;
					}
					return false;
				}
				
				public double getAperture()
				{
					double value;
					
					double scaleFactor = ( 128.0 - 0.1 ) / 65535.0;
					double bias = 0.1;
					
					value = m_Aperture * scaleFactor + bias;
					
					return value;
				}
				
				public void setAperture(double value)
				{
					if ((value >= 0.1) && (value <= 128.0))
					{
						double scaleFactor = ( 128.0 - 0.1 ) / 65535.0;
						double bias = 0.1;
						
						m_Aperture= (int)((value - bias) / scaleFactor);
						setPresenceVector(13);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isLightSensitivityValid()
				{
					if (checkPresenceVector(14))
					{
						return true;
					}
					return false;
				}
				
				public short getLightSensitivity()
				{
					return m_LightSensitivity;
				}
				
				public void setLightSensitivity(short value)
				{
					if ((value == 0) || (value == 1) || (value == 2) || (value == 3) || (value == 4) || (value == 5) || (value == 6))
					{
						m_LightSensitivity = value;
						setPresenceVector(14);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isImageStablizationValid()
				{
					if (checkPresenceVector(15))
					{
						return true;
					}
					return false;
				}
				
				public short getImageStablization()
				{
					return m_ImageStablization;
				}
				
				public void setImageStablization(short value)
				{
					if ((value == 0) || (value == 1))
					{
						m_ImageStablization = value;
						setPresenceVector(15);
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
					
					size += JausUtils.getNumBytes("int");
					size += JausUtils.getNumBytes("short");
					if (checkPresenceVector(0))
					{
						size += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(1))
					{
						size += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(2))
					{
						size += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(3))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(4))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(5))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(6))
					{
						size += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(7))
					{
						size += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(8))
					{
						size += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(9))
					{
						size += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(10))
					{
						size += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(11))
					{
						size += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(12))
					{
						size += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(13))
					{
						size += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(14))
					{
						size += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(15))
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
						long m_PresenceVectorTemp = (long) JausUtils.getPVInt(m_PresenceVector);
					bytes.putInt(pos, (int) m_PresenceVectorTemp);
					pos += JausUtils.getNumBytes("int");
					}
					catch(Exception e)
					{
						logger.log(Level.SEVERE, null, e);
					}
					bytes.putShort(pos, (short) m_SensorID);
					pos += JausUtils.getNumBytes("short");
					if (checkPresenceVector(0))
					{
						bytes.put(pos, (byte) m_SensorState);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(1))
					{
						bytes.put(pos, (byte) m_ZoomMode);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(2))
					{
						bytes.putShort(pos, (short) m_ZoomLevel);
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(3))
					{
						bytes.putInt(pos, (int) m_FocalLength);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(4))
					{
						bytes.putInt(pos, (int) m_HorizontalFieldOfView);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(5))
					{
						bytes.putInt(pos, (int) m_VerticalFieldOfView);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(6))
					{
						bytes.put(pos, (byte) m_FocusMode);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(7))
					{
						bytes.putShort(pos, (short) m_FocusValue);
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(8))
					{
						bytes.put(pos, (byte) m_WhiteBalance);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(9))
					{
						bytes.put(pos, (byte) m_ImagingMode);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(10))
					{
						bytes.put(pos, (byte) m_ExposureMode);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(11))
					{
						bytes.put(pos, (byte) m_MeteringMode);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(12))
					{
						bytes.putShort(pos, (short) m_ShutterSpeed);
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(13))
					{
						bytes.putShort(pos, (short) m_Aperture);
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(14))
					{
						bytes.put(pos, (byte) m_LightSensitivity);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(15))
					{
						bytes.put(pos, (byte) m_ImageStablization);
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
						long m_PresenceVectorTemp = 0;
					m_PresenceVectorTemp = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
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
						m_SensorState = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(1))
					{
						m_ZoomMode = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(2))
					{
						m_ZoomLevel = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(3))
					{
						m_FocalLength = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(4))
					{
						m_HorizontalFieldOfView = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(5))
					{
						m_VerticalFieldOfView = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(6))
					{
						m_FocusMode = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(7))
					{
						m_FocusValue = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(8))
					{
						m_WhiteBalance = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(9))
					{
						m_ImagingMode = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(10))
					{
						m_ExposureMode = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(11))
					{
						m_MeteringMode = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(12))
					{
						m_ShutterSpeed = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(13))
					{
						m_Aperture = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(14))
					{
						m_LightSensitivity = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					if (checkPresenceVector(15))
					{
						m_ImageStablization = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
				}
				
				public ReportVisualSensorConfiguration.Body.VisualSensorConfigurationList.VisualSensorConfigurationRec assign(VisualSensorConfigurationRec value)
				{
					m_PresenceVector = value.m_PresenceVector;
					m_SensorID = value.m_SensorID;
					m_SensorState = value.m_SensorState;
					m_ZoomMode = value.m_ZoomMode;
					m_ZoomLevel = value.m_ZoomLevel;
					m_FocalLength = value.m_FocalLength;
					m_HorizontalFieldOfView = value.m_HorizontalFieldOfView;
					m_VerticalFieldOfView = value.m_VerticalFieldOfView;
					m_FocusMode = value.m_FocusMode;
					m_FocusValue = value.m_FocusValue;
					m_WhiteBalance = value.m_WhiteBalance;
					m_ImagingMode = value.m_ImagingMode;
					m_ExposureMode = value.m_ExposureMode;
					m_MeteringMode = value.m_MeteringMode;
					m_ShutterSpeed = value.m_ShutterSpeed;
					m_Aperture = value.m_Aperture;
					m_LightSensitivity = value.m_LightSensitivity;
					m_ImageStablization = value.m_ImageStablization;
					
					return this;
				}
				
				public boolean isEqual(VisualSensorConfigurationRec value)
				{
					if (!m_PresenceVector.equals(value.m_PresenceVector))
					{
						return false;
					}
					if (m_SensorID != value.getSensorID())
					{
						return false;
					}
					if (m_SensorState != value.getSensorState())
					{
						return false;
					}
					if (m_ZoomMode != value.getZoomMode())
					{
						return false;
					}
					if (m_ZoomLevel != value.getZoomLevel())
					{
						return false;
					}
					if (m_FocalLength != value.getFocalLength())
					{
						return false;
					}
					if (m_HorizontalFieldOfView != value.getHorizontalFieldOfView())
					{
						return false;
					}
					if (m_VerticalFieldOfView != value.getVerticalFieldOfView())
					{
						return false;
					}
					if (m_FocusMode != value.getFocusMode())
					{
						return false;
					}
					if (m_FocusValue != value.getFocusValue())
					{
						return false;
					}
					if (m_WhiteBalance != value.getWhiteBalance())
					{
						return false;
					}
					if (m_ImagingMode != value.getImagingMode())
					{
						return false;
					}
					if (m_ExposureMode != value.getExposureMode())
					{
						return false;
					}
					if (m_MeteringMode != value.getMeteringMode())
					{
						return false;
					}
					if (m_ShutterSpeed != value.getShutterSpeed())
					{
						return false;
					}
					if (m_Aperture != value.getAperture())
					{
						return false;
					}
					if (m_LightSensitivity != value.getLightSensitivity())
					{
						return false;
					}
					if (m_ImageStablization != value.getImageStablization())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(VisualSensorConfigurationRec value)
				{
					return !this.isEqual(value);
				}
				
				public VisualSensorConfigurationRec()
				{
					m_parent = null;
					m_PresenceVector = new BitSet();
					m_PresenceVectorTemp = 0;
					m_SensorID = 0;
					m_SensorState = 0;
					m_ZoomMode = 0;
					m_ZoomLevel = 0;
					m_FocalLength = 0;
					m_HorizontalFieldOfView = 0;
					m_VerticalFieldOfView = 0;
					m_FocusMode = 0;
					m_FocusValue = 0;
					m_WhiteBalance = 0;
					m_ImagingMode = 0;
					m_ExposureMode = 0;
					m_MeteringMode = 0;
					m_ShutterSpeed = 0;
					m_Aperture = 0;
					m_LightSensitivity = 0;
					m_ImageStablization = 0;
				}
				
				public VisualSensorConfigurationRec(VisualSensorConfigurationRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_PresenceVector = new BitSet();
					m_PresenceVectorTemp = 0;
					m_SensorID = 0;
					m_SensorState = 0;
					m_ZoomMode = 0;
					m_ZoomLevel = 0;
					m_FocalLength = 0;
					m_HorizontalFieldOfView = 0;
					m_VerticalFieldOfView = 0;
					m_FocusMode = 0;
					m_FocusValue = 0;
					m_WhiteBalance = 0;
					m_ImagingMode = 0;
					m_ExposureMode = 0;
					m_MeteringMode = 0;
					m_ShutterSpeed = 0;
					m_Aperture = 0;
					m_LightSensitivity = 0;
					m_ImageStablization = 0;
					
					/// Copy the values
					m_PresenceVector = value.m_PresenceVector;
					m_SensorID = value.m_SensorID;
					m_SensorState = value.m_SensorState;
					m_ZoomMode = value.m_ZoomMode;
					m_ZoomLevel = value.m_ZoomLevel;
					m_FocalLength = value.m_FocalLength;
					m_HorizontalFieldOfView = value.m_HorizontalFieldOfView;
					m_VerticalFieldOfView = value.m_VerticalFieldOfView;
					m_FocusMode = value.m_FocusMode;
					m_FocusValue = value.m_FocusValue;
					m_WhiteBalance = value.m_WhiteBalance;
					m_ImagingMode = value.m_ImagingMode;
					m_ExposureMode = value.m_ExposureMode;
					m_MeteringMode = value.m_MeteringMode;
					m_ShutterSpeed = value.m_ShutterSpeed;
					m_Aperture = value.m_Aperture;
					m_LightSensitivity = value.m_LightSensitivity;
					m_ImageStablization = value.m_ImageStablization;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<VisualSensorConfigurationRec> m_VisualSensorConfigurationRec;
		
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
				return (long) m_VisualSensorConfigurationRec.size();
			}
			
			public ReportVisualSensorConfiguration.Body.VisualSensorConfigurationList.VisualSensorConfigurationRec getElement(int index)
			{
				return m_VisualSensorConfigurationRec.get(index);
			}
			
			public void setElement(int index, VisualSensorConfigurationRec value)
			{
				if(m_VisualSensorConfigurationRec.size()-1 < index)
				{
					return;
				}
				
				m_VisualSensorConfigurationRec.set(index, value);
				m_VisualSensorConfigurationRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(VisualSensorConfigurationRec value)
			{
				m_VisualSensorConfigurationRec.add(value);
				m_VisualSensorConfigurationRec.get(m_VisualSensorConfigurationRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_VisualSensorConfigurationRec.size()-1 < index)
				{
					return 1;
				}
				
				m_VisualSensorConfigurationRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_VisualSensorConfigurationRec.remove(m_VisualSensorConfigurationRec.size()-1);
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
				for (int i = 0; i < m_VisualSensorConfigurationRec.size(); i++)
				{
					size += m_VisualSensorConfigurationRec.get(i).getSize();
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
				
				int size = (int) m_VisualSensorConfigurationRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_VisualSensorConfigurationRec.size(); i++)
				{
					m_VisualSensorConfigurationRec.get(i).encode(bytes, pos);
					pos += m_VisualSensorConfigurationRec.get(i).getSize();
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
				m_VisualSensorConfigurationRec = new ArrayList<VisualSensorConfigurationRec>();
				for (int i = 0; i <  size; i++)
				{
					VisualSensorConfigurationRec item = new VisualSensorConfigurationRec();
					item.decode(bytes, pos);
					m_VisualSensorConfigurationRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportVisualSensorConfiguration.Body.VisualSensorConfigurationList assign(VisualSensorConfigurationList value)
			{
				m_VisualSensorConfigurationRec.clear();
				
				for (int i = 0; i < value.m_VisualSensorConfigurationRec.size(); i++)
				{
					m_VisualSensorConfigurationRec.add(value.m_VisualSensorConfigurationRec.get(i));
					m_VisualSensorConfigurationRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(VisualSensorConfigurationList value)
			{
				for (int i = 0; i < m_VisualSensorConfigurationRec.size(); i++)
				{
					if (!m_VisualSensorConfigurationRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(VisualSensorConfigurationList value)
			{
				return !this.isEqual(value);
			}
			
			public VisualSensorConfigurationList()
			{
				m_parent = null;
				m_VisualSensorConfigurationRec = new ArrayList<VisualSensorConfigurationRec>();
				for (int i = 0; i < m_VisualSensorConfigurationRec.size(); i++)
				{
					m_VisualSensorConfigurationRec.get(i).setParent(this);
				}
			}
			
			public VisualSensorConfigurationList(VisualSensorConfigurationList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_VisualSensorConfigurationRec = new ArrayList<VisualSensorConfigurationRec>();
				for (int i = 0; i < m_VisualSensorConfigurationRec.size(); i++)
				{
					m_VisualSensorConfigurationRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_VisualSensorConfigurationRec.clear();
				
				for (int i = 0; i < value.m_VisualSensorConfigurationRec.size(); i++)
				{
					m_VisualSensorConfigurationRec.add(value.m_VisualSensorConfigurationRec.get(i));
					m_VisualSensorConfigurationRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected VisualSensorConfigurationList m_VisualSensorConfigurationList;
	
		public ReportVisualSensorConfiguration.Body.VisualSensorConfigurationList getVisualSensorConfigurationList()
		{
			return m_VisualSensorConfigurationList;
		}
		
		public void setVisualSensorConfigurationList(VisualSensorConfigurationList value)
		{
			m_VisualSensorConfigurationList = value;
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
			
			size += m_VisualSensorConfigurationList.getSize();
			
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
			
			m_VisualSensorConfigurationList.encode(bytes, pos);
			pos += m_VisualSensorConfigurationList.getSize();
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
			
			m_VisualSensorConfigurationList.decode(bytes, pos);
			pos += m_VisualSensorConfigurationList.getSize();
		}
		
		public ReportVisualSensorConfiguration.Body assign(Body value)
		{
			m_VisualSensorConfigurationList = value.m_VisualSensorConfigurationList;
			m_VisualSensorConfigurationList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_VisualSensorConfigurationList.isEqual(value.m_VisualSensorConfigurationList))
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
			m_VisualSensorConfigurationList = new VisualSensorConfigurationList();
			m_VisualSensorConfigurationList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_VisualSensorConfigurationList = new VisualSensorConfigurationList();
			m_VisualSensorConfigurationList.setParent(this);
			
			/// Copy the values
			m_VisualSensorConfigurationList = value.m_VisualSensorConfigurationList;
			m_VisualSensorConfigurationList.setParent(this);
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
	public ReportVisualSensorConfiguration.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportVisualSensorConfiguration.Body getBody()
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
	
	public ReportVisualSensorConfiguration setAs(ReportVisualSensorConfiguration value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportVisualSensorConfiguration value)
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
	
	public boolean notEquals(ReportVisualSensorConfiguration value)
	{
		return !isEqual(value);
	}
	
	public ReportVisualSensorConfiguration()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportVisualSensorConfiguration(ReportVisualSensorConfiguration value)
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
