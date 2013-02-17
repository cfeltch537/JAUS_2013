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

public class ReportVisualSensorCapabilities extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4806;
	
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
			
			public ReportVisualSensorCapabilities.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4806;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4806;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportVisualSensorCapabilities.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportVisualSensorCapabilities.AppHeader assign(AppHeader value)
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
		public static class  VisualSensorCapabilitiesList
		{
			public static class  VisualSensorCapabilitiesRec
			{
				public static class  SupportedStates
				{
				
					protected VisualSensorCapabilitiesRec m_parent;
					protected short m_SubFields;
				
					public void setParent(VisualSensorCapabilitiesRec parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setPresenceVector(0);
							m_parent.setParentPresenceVector();
						}
					}
					
					public short getActive()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 0; index <= 0; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setActive(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 0; index <= 0; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getStandby()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 1; index <= 1; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setStandby(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 1; index <= 1; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getOff()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 2; index <= 2; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setOff(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 2; index <= 2; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
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
						
						
						bytes.put(pos, (byte) m_SubFields);
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
						
						m_SubFields = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					
					public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.SupportedStates assign(SupportedStates value)
					{
						this.m_SubFields = value.m_SubFields;
						
						return this;
					}
					
					public boolean isEqual(SupportedStates value)
					{
						return this.m_SubFields == value.getOff();
					}
					
					public boolean notEquals(SupportedStates value)
					{
						return !this.isEqual(value);
					}
					
					public SupportedStates()
					{
						m_parent = null;
						m_SubFields = 0;
					}
					
					public SupportedStates(SupportedStates value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SubFields = 0;
						
						/// Copy the values
						this.m_SubFields = value.m_SubFields;
					}
					
					public void finalize()
					{
					}
					
				}
				public static class  ZoomModes
				{
				
					protected VisualSensorCapabilitiesRec m_parent;
					protected short m_SubFields;
				
					public void setParent(VisualSensorCapabilitiesRec parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setPresenceVector(1);
							m_parent.setParentPresenceVector();
						}
					}
					
					public short getMixed()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 0; index <= 0; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setMixed(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 0; index <= 0; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getAnalogOnly()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 1; index <= 1; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setAnalogOnly(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 1; index <= 1; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getDigitalOnly()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 2; index <= 2; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setDigitalOnly(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 2; index <= 2; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getNone()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 3; index <= 3; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setNone(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 3; index <= 3; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
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
						
						
						bytes.put(pos, (byte) m_SubFields);
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
						
						m_SubFields = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					
					public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.ZoomModes assign(ZoomModes value)
					{
						this.m_SubFields = value.m_SubFields;
						
						return this;
					}
					
					public boolean isEqual(ZoomModes value)
					{
						return this.m_SubFields == value.getNone();
					}
					
					public boolean notEquals(ZoomModes value)
					{
						return !this.isEqual(value);
					}
					
					public ZoomModes()
					{
						m_parent = null;
						m_SubFields = 0;
					}
					
					public ZoomModes(ZoomModes value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SubFields = 0;
						
						/// Copy the values
						this.m_SubFields = value.m_SubFields;
					}
					
					public void finalize()
					{
					}
					
				}
				public static class  FocusModes
				{
				
					protected VisualSensorCapabilitiesRec m_parent;
					protected short m_SubFields;
				
					public void setParent(VisualSensorCapabilitiesRec parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setPresenceVector(2);
							m_parent.setParentPresenceVector();
						}
					}
					
					public short getAutoFocus()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 0; index <= 0; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setAutoFocus(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 0; index <= 0; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getManualFocus()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 1; index <= 1; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setManualFocus(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 1; index <= 1; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
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
						
						
						bytes.put(pos, (byte) m_SubFields);
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
						
						m_SubFields = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					
					public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.FocusModes assign(FocusModes value)
					{
						this.m_SubFields = value.m_SubFields;
						
						return this;
					}
					
					public boolean isEqual(FocusModes value)
					{
						return this.m_SubFields == value.getManualFocus();
					}
					
					public boolean notEquals(FocusModes value)
					{
						return !this.isEqual(value);
					}
					
					public FocusModes()
					{
						m_parent = null;
						m_SubFields = 0;
					}
					
					public FocusModes(FocusModes value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SubFields = 0;
						
						/// Copy the values
						this.m_SubFields = value.m_SubFields;
					}
					
					public void finalize()
					{
					}
					
				}
				public static class  WhiteBalance
				{
				
					protected VisualSensorCapabilitiesRec m_parent;
					protected short m_SubFields;
				
					public void setParent(VisualSensorCapabilitiesRec parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setPresenceVector(3);
							m_parent.setParentPresenceVector();
						}
					}
					
					public short getAuto()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 0; index <= 0; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setAuto(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 0; index <= 0; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getDaylight()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 1; index <= 1; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setDaylight(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 1; index <= 1; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getCloudy()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 2; index <= 2; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setCloudy(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 2; index <= 2; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getShade()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 3; index <= 3; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setShade(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 3; index <= 3; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getTungsten()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 4; index <= 4; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setTungsten(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 4; index <= 4; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getFlurescent()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 5; index <= 5; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setFlurescent(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 5; index <= 5; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getFlash()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 6; index <= 6; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setFlash(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 6; index <= 6; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
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
						
						
						bytes.put(pos, (byte) m_SubFields);
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
						
						m_SubFields = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					
					public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.WhiteBalance assign(WhiteBalance value)
					{
						this.m_SubFields = value.m_SubFields;
						
						return this;
					}
					
					public boolean isEqual(WhiteBalance value)
					{
						return this.m_SubFields == value.getFlash();
					}
					
					public boolean notEquals(WhiteBalance value)
					{
						return !this.isEqual(value);
					}
					
					public WhiteBalance()
					{
						m_parent = null;
						m_SubFields = 0;
					}
					
					public WhiteBalance(WhiteBalance value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SubFields = 0;
						
						/// Copy the values
						this.m_SubFields = value.m_SubFields;
					}
					
					public void finalize()
					{
					}
					
				}
				public static class  ImagingModes
				{
				
					protected VisualSensorCapabilitiesRec m_parent;
					protected short m_SubFields;
				
					public void setParent(VisualSensorCapabilitiesRec parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setPresenceVector(4);
							m_parent.setParentPresenceVector();
						}
					}
					
					public short getColor()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 0; index <= 0; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setColor(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 0; index <= 0; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getGreyscale()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 1; index <= 1; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setGreyscale(short value)
					{
						if ((value == 1) || (value == 0))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 1; index <= 1; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getInfrared()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 2; index <= 2; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setInfrared(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 2; index <= 2; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getLowlight()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 3; index <= 3; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setLowlight(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 3; index <= 3; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
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
						
						
						bytes.put(pos, (byte) m_SubFields);
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
						
						m_SubFields = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					
					public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.ImagingModes assign(ImagingModes value)
					{
						this.m_SubFields = value.m_SubFields;
						
						return this;
					}
					
					public boolean isEqual(ImagingModes value)
					{
						return this.m_SubFields == value.getLowlight();
					}
					
					public boolean notEquals(ImagingModes value)
					{
						return !this.isEqual(value);
					}
					
					public ImagingModes()
					{
						m_parent = null;
						m_SubFields = 0;
					}
					
					public ImagingModes(ImagingModes value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SubFields = 0;
						
						/// Copy the values
						this.m_SubFields = value.m_SubFields;
					}
					
					public void finalize()
					{
					}
					
				}
				public static class  ExposureModes
				{
				
					protected VisualSensorCapabilitiesRec m_parent;
					protected short m_SubFields;
				
					public void setParent(VisualSensorCapabilitiesRec parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setPresenceVector(5);
							m_parent.setParentPresenceVector();
						}
					}
					
					public short getAuto()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 0; index <= 0; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setAuto(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 0; index <= 0; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getManual()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 1; index <= 1; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setManual(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 1; index <= 1; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getShutterPriority()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 2; index <= 2; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setShutterPriority(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 2; index <= 2; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getAperturePriority()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 3; index <= 3; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setAperturePriority(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 3; index <= 3; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
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
						
						
						bytes.put(pos, (byte) m_SubFields);
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
						
						m_SubFields = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					
					public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.ExposureModes assign(ExposureModes value)
					{
						this.m_SubFields = value.m_SubFields;
						
						return this;
					}
					
					public boolean isEqual(ExposureModes value)
					{
						return this.m_SubFields == value.getAperturePriority();
					}
					
					public boolean notEquals(ExposureModes value)
					{
						return !this.isEqual(value);
					}
					
					public ExposureModes()
					{
						m_parent = null;
						m_SubFields = 0;
					}
					
					public ExposureModes(ExposureModes value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SubFields = 0;
						
						/// Copy the values
						this.m_SubFields = value.m_SubFields;
					}
					
					public void finalize()
					{
					}
					
				}
				public static class  MeteringModes
				{
				
					protected VisualSensorCapabilitiesRec m_parent;
					protected short m_SubFields;
				
					public void setParent(VisualSensorCapabilitiesRec parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setPresenceVector(6);
							m_parent.setParentPresenceVector();
						}
					}
					
					public short getMatrixOrAuto()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 0; index <= 0; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setMatrixOrAuto(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 0; index <= 0; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getCenterWeighted()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 1; index <= 1; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setCenterWeighted(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 1; index <= 1; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getSpot()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 2; index <= 2; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setSpot(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 2; index <= 2; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
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
						
						
						bytes.put(pos, (byte) m_SubFields);
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
						
						m_SubFields = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					
					public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.MeteringModes assign(MeteringModes value)
					{
						this.m_SubFields = value.m_SubFields;
						
						return this;
					}
					
					public boolean isEqual(MeteringModes value)
					{
						return this.m_SubFields == value.getSpot();
					}
					
					public boolean notEquals(MeteringModes value)
					{
						return !this.isEqual(value);
					}
					
					public MeteringModes()
					{
						m_parent = null;
						m_SubFields = 0;
					}
					
					public MeteringModes(MeteringModes value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SubFields = 0;
						
						/// Copy the values
						this.m_SubFields = value.m_SubFields;
					}
					
					public void finalize()
					{
					}
					
				}
				public static class  LightSensitivityLevels
				{
				
					protected VisualSensorCapabilitiesRec m_parent;
					protected short m_SubFields;
				
					public void setParent(VisualSensorCapabilitiesRec parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setPresenceVector(13);
							m_parent.setParentPresenceVector();
						}
					}
					
					public short getISO1600()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 5; index <= 5; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setISO1600(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 5; index <= 5; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getISO3200()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 6; index <= 6; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setISO3200(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 6; index <= 6; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getAuto()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 0; index <= 0; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setAuto(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 0; index <= 0; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getISO100()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 1; index <= 1; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setISO100(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 1; index <= 1; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getISO200()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 2; index <= 2; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setISO200(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 2; index <= 2; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getISO400()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 3; index <= 3; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setISO400(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 3; index <= 3; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getISO800()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 4; index <= 4; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setISO800(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 4; index <= 4; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
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
						
						
						bytes.put(pos, (byte) m_SubFields);
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
						
						m_SubFields = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					
					public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.LightSensitivityLevels assign(LightSensitivityLevels value)
					{
						this.m_SubFields = value.m_SubFields;
						
						return this;
					}
					
					public boolean isEqual(LightSensitivityLevels value)
					{
						return this.m_SubFields == value.getISO800();
					}
					
					public boolean notEquals(LightSensitivityLevels value)
					{
						return !this.isEqual(value);
					}
					
					public LightSensitivityLevels()
					{
						m_parent = null;
						m_SubFields = 0;
					}
					
					public LightSensitivityLevels(LightSensitivityLevels value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SubFields = 0;
						
						/// Copy the values
						this.m_SubFields = value.m_SubFields;
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected VisualSensorCapabilitiesList m_parent;
				protected BitSet m_PresenceVector;
				protected int m_PresenceVectorTemp;
				protected int m_SensorID;
				protected String m_SensorName;
				protected SupportedStates m_SupportedStates;
				protected ZoomModes m_ZoomModes;
				protected FocusModes m_FocusModes;
				protected WhiteBalance m_WhiteBalance;
				protected ImagingModes m_ImagingModes;
				protected ExposureModes m_ExposureModes;
				protected MeteringModes m_MeteringModes;
				protected int m_MinimumShutterSpeed;
				protected int m_MaximumShutterSpeed;
				protected int m_MinimumAperture;
				protected int m_MaximumAperture;
				protected long m_MinimumFocalLength;
				protected long m_MaximumFocalLength;
				protected LightSensitivityLevels m_LightSensitivityLevels;
				protected short m_ImageStabilization;
			
				public void setParent(VisualSensorCapabilitiesList parent)
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
				
				public String getSensorName()
				{
					return m_SensorName;
				}
				
				public void setSensorName(String value)
				{
					if ( value.length() > 255)
					{
						return;
					}
					
					m_SensorName = value;
					if (m_SensorName.length() < 0)
					{
						m_SensorName = m_SensorName.substring(0, 0);
					}
					setParentPresenceVector();
				}
				
				public boolean isSupportedStatesValid()
				{
					if (checkPresenceVector(0))
					{
						return true;
					}
					return false;
				}
				
				public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.SupportedStates getSupportedStates()
				{
					return m_SupportedStates;
				}
				
				public void setSupportedStates(SupportedStates value)
				{
					m_SupportedStates = value;
					setPresenceVector(0);
					setParentPresenceVector();
				}
				
				public boolean isZoomModesValid()
				{
					if (checkPresenceVector(1))
					{
						return true;
					}
					return false;
				}
				
				public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.ZoomModes getZoomModes()
				{
					return m_ZoomModes;
				}
				
				public void setZoomModes(ZoomModes value)
				{
					m_ZoomModes = value;
					setPresenceVector(1);
					setParentPresenceVector();
				}
				
				public boolean isFocusModesValid()
				{
					if (checkPresenceVector(2))
					{
						return true;
					}
					return false;
				}
				
				public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.FocusModes getFocusModes()
				{
					return m_FocusModes;
				}
				
				public void setFocusModes(FocusModes value)
				{
					m_FocusModes = value;
					setPresenceVector(2);
					setParentPresenceVector();
				}
				
				public boolean isWhiteBalanceValid()
				{
					if (checkPresenceVector(3))
					{
						return true;
					}
					return false;
				}
				
				public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.WhiteBalance getWhiteBalance()
				{
					return m_WhiteBalance;
				}
				
				public void setWhiteBalance(WhiteBalance value)
				{
					m_WhiteBalance = value;
					setPresenceVector(3);
					setParentPresenceVector();
				}
				
				public boolean isImagingModesValid()
				{
					if (checkPresenceVector(4))
					{
						return true;
					}
					return false;
				}
				
				public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.ImagingModes getImagingModes()
				{
					return m_ImagingModes;
				}
				
				public void setImagingModes(ImagingModes value)
				{
					m_ImagingModes = value;
					setPresenceVector(4);
					setParentPresenceVector();
				}
				
				public boolean isExposureModesValid()
				{
					if (checkPresenceVector(5))
					{
						return true;
					}
					return false;
				}
				
				public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.ExposureModes getExposureModes()
				{
					return m_ExposureModes;
				}
				
				public void setExposureModes(ExposureModes value)
				{
					m_ExposureModes = value;
					setPresenceVector(5);
					setParentPresenceVector();
				}
				
				public boolean isMeteringModesValid()
				{
					if (checkPresenceVector(6))
					{
						return true;
					}
					return false;
				}
				
				public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.MeteringModes getMeteringModes()
				{
					return m_MeteringModes;
				}
				
				public void setMeteringModes(MeteringModes value)
				{
					m_MeteringModes = value;
					setPresenceVector(6);
					setParentPresenceVector();
				}
				
				public boolean isMinimumShutterSpeedValid()
				{
					if (checkPresenceVector(7))
					{
						return true;
					}
					return false;
				}
				
				public double getMinimumShutterSpeed()
				{
					double value;
					
					double scaleFactor = ( 60.0 - 0.0 ) / 65535.0;
					double bias = 0.0;
					
					value = m_MinimumShutterSpeed * scaleFactor + bias;
					
					return value;
				}
				
				public void setMinimumShutterSpeed(double value)
				{
					if ((value >= 0.0) && (value <= 60.0))
					{
						double scaleFactor = ( 60.0 - 0.0 ) / 65535.0;
						double bias = 0.0;
						
						m_MinimumShutterSpeed= (int)((value - bias) / scaleFactor);
						setPresenceVector(7);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMaximumShutterSpeedValid()
				{
					if (checkPresenceVector(8))
					{
						return true;
					}
					return false;
				}
				
				public double getMaximumShutterSpeed()
				{
					double value;
					
					double scaleFactor = ( 60.0 - 0.0 ) / 65535.0;
					double bias = 0.0;
					
					value = m_MaximumShutterSpeed * scaleFactor + bias;
					
					return value;
				}
				
				public void setMaximumShutterSpeed(double value)
				{
					if ((value >= 0.0) && (value <= 60.0))
					{
						double scaleFactor = ( 60.0 - 0.0 ) / 65535.0;
						double bias = 0.0;
						
						m_MaximumShutterSpeed= (int)((value - bias) / scaleFactor);
						setPresenceVector(8);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMinimumApertureValid()
				{
					if (checkPresenceVector(9))
					{
						return true;
					}
					return false;
				}
				
				public double getMinimumAperture()
				{
					double value;
					
					double scaleFactor = ( 128.0 - 0.1 ) / 65535.0;
					double bias = 0.1;
					
					value = m_MinimumAperture * scaleFactor + bias;
					
					return value;
				}
				
				public void setMinimumAperture(double value)
				{
					if ((value >= 0.1) && (value <= 128.0))
					{
						double scaleFactor = ( 128.0 - 0.1 ) / 65535.0;
						double bias = 0.1;
						
						m_MinimumAperture= (int)((value - bias) / scaleFactor);
						setPresenceVector(9);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMaximumApertureValid()
				{
					if (checkPresenceVector(10))
					{
						return true;
					}
					return false;
				}
				
				public double getMaximumAperture()
				{
					double value;
					
					double scaleFactor = ( 128.0 - 0.1 ) / 65535.0;
					double bias = 0.1;
					
					value = m_MaximumAperture * scaleFactor + bias;
					
					return value;
				}
				
				public void setMaximumAperture(double value)
				{
					if ((value >= 0.1) && (value <= 128.0))
					{
						double scaleFactor = ( 128.0 - 0.1 ) / 65535.0;
						double bias = 0.1;
						
						m_MaximumAperture= (int)((value - bias) / scaleFactor);
						setPresenceVector(10);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMinimumFocalLengthValid()
				{
					if (checkPresenceVector(11))
					{
						return true;
					}
					return false;
				}
				
				public double getMinimumFocalLength()
				{
					double value;
					
					double scaleFactor = ( 2.0 - 0.0 ) / 4.294967295E9;
					double bias = 0.0;
					
					value = m_MinimumFocalLength * scaleFactor + bias;
					
					return value;
				}
				
				public void setMinimumFocalLength(double value)
				{
					if ((value >= 0.0) && (value <= 2.0))
					{
						double scaleFactor = ( 2.0 - 0.0 ) / 4.294967295E9;
						double bias = 0.0;
						
						m_MinimumFocalLength= (long)((value - bias) / scaleFactor);
						setPresenceVector(11);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMaximumFocalLengthValid()
				{
					if (checkPresenceVector(12))
					{
						return true;
					}
					return false;
				}
				
				public double getMaximumFocalLength()
				{
					double value;
					
					double scaleFactor = ( 2.0 - 0.0 ) / 4.294967295E9;
					double bias = 0.0;
					
					value = m_MaximumFocalLength * scaleFactor + bias;
					
					return value;
				}
				
				public void setMaximumFocalLength(double value)
				{
					if ((value >= 0.0) && (value <= 2.0))
					{
						double scaleFactor = ( 2.0 - 0.0 ) / 4.294967295E9;
						double bias = 0.0;
						
						m_MaximumFocalLength= (long)((value - bias) / scaleFactor);
						setPresenceVector(12);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isLightSensitivityLevelsValid()
				{
					if (checkPresenceVector(13))
					{
						return true;
					}
					return false;
				}
				
				public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec.LightSensitivityLevels getLightSensitivityLevels()
				{
					return m_LightSensitivityLevels;
				}
				
				public void setLightSensitivityLevels(LightSensitivityLevels value)
				{
					m_LightSensitivityLevels = value;
					setPresenceVector(13);
					setParentPresenceVector();
				}
				
				public boolean isImageStabilizationValid()
				{
					if (checkPresenceVector(14))
					{
						return true;
					}
					return false;
				}
				
				public short getImageStabilization()
				{
					return m_ImageStabilization;
				}
				
				public void setImageStabilization(short value)
				{
					if ((value == 0) || (value == 1))
					{
						m_ImageStabilization = value;
						setPresenceVector(14);
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
					size += JausUtils.getNumBytes("byte");
					size += m_SensorName.length();
					if (checkPresenceVector(0))
					{
						size += m_SupportedStates.getSize();
					}
					if (checkPresenceVector(1))
					{
						size += m_ZoomModes.getSize();
					}
					if (checkPresenceVector(2))
					{
						size += m_FocusModes.getSize();
					}
					if (checkPresenceVector(3))
					{
						size += m_WhiteBalance.getSize();
					}
					if (checkPresenceVector(4))
					{
						size += m_ImagingModes.getSize();
					}
					if (checkPresenceVector(5))
					{
						size += m_ExposureModes.getSize();
					}
					if (checkPresenceVector(6))
					{
						size += m_MeteringModes.getSize();
					}
					if (checkPresenceVector(7))
					{
						size += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(8))
					{
						size += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(9))
					{
						size += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(10))
					{
						size += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(11))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(12))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(13))
					{
						size += m_LightSensitivityLevels.getSize();
					}
					if (checkPresenceVector(14))
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
					
					try
					{
					bytes.put(pos, (byte) m_SensorName.length());
					pos += JausUtils.getNumBytes("byte");
					
					char[] m_SensorNameBytes = m_SensorName.toCharArray();
					for(int str_pos = 0; str_pos<m_SensorNameBytes.length; str_pos++)
					{
						bytes.put(pos, (byte) m_SensorNameBytes[str_pos]);
						pos++;
					}
					}
					catch (Exception e)
					{
						
					}
					if (checkPresenceVector(0))
					{
						m_SupportedStates.encode(bytes, pos);
						pos += m_SupportedStates.getSize();
					}
					if (checkPresenceVector(1))
					{
						m_ZoomModes.encode(bytes, pos);
						pos += m_ZoomModes.getSize();
					}
					if (checkPresenceVector(2))
					{
						m_FocusModes.encode(bytes, pos);
						pos += m_FocusModes.getSize();
					}
					if (checkPresenceVector(3))
					{
						m_WhiteBalance.encode(bytes, pos);
						pos += m_WhiteBalance.getSize();
					}
					if (checkPresenceVector(4))
					{
						m_ImagingModes.encode(bytes, pos);
						pos += m_ImagingModes.getSize();
					}
					if (checkPresenceVector(5))
					{
						m_ExposureModes.encode(bytes, pos);
						pos += m_ExposureModes.getSize();
					}
					if (checkPresenceVector(6))
					{
						m_MeteringModes.encode(bytes, pos);
						pos += m_MeteringModes.getSize();
					}
					if (checkPresenceVector(7))
					{
						bytes.putShort(pos, (short) m_MinimumShutterSpeed);
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(8))
					{
						bytes.putShort(pos, (short) m_MaximumShutterSpeed);
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(9))
					{
						bytes.putShort(pos, (short) m_MinimumAperture);
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(10))
					{
						bytes.putShort(pos, (short) m_MaximumAperture);
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(11))
					{
						bytes.putInt(pos, (int) m_MinimumFocalLength);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(12))
					{
						bytes.putInt(pos, (int) m_MaximumFocalLength);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(13))
					{
						m_LightSensitivityLevels.encode(bytes, pos);
						pos += m_LightSensitivityLevels.getSize();
					}
					if (checkPresenceVector(14))
					{
						bytes.put(pos, (byte) m_ImageStabilization);
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
					
					short m_SensorNameLength = 0;
					m_SensorNameLength = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
					
					
					// Decoding the string m_SensorNamefrom the buffer.
					char[] m_SensorNameBytes = new char[(int)m_SensorNameLength];
					for(int decode_pos = 0; decode_pos<(int)m_SensorNameLength;decode_pos++)
					{
						m_SensorNameBytes[decode_pos] = (char) (bytes.get(pos) &0xff);
						pos++;
					}
					m_SensorName = new String(m_SensorNameBytes);
					if (checkPresenceVector(0))
					{
						m_SupportedStates.decode(bytes, pos);
						pos += m_SupportedStates.getSize();
					}
					if (checkPresenceVector(1))
					{
						m_ZoomModes.decode(bytes, pos);
						pos += m_ZoomModes.getSize();
					}
					if (checkPresenceVector(2))
					{
						m_FocusModes.decode(bytes, pos);
						pos += m_FocusModes.getSize();
					}
					if (checkPresenceVector(3))
					{
						m_WhiteBalance.decode(bytes, pos);
						pos += m_WhiteBalance.getSize();
					}
					if (checkPresenceVector(4))
					{
						m_ImagingModes.decode(bytes, pos);
						pos += m_ImagingModes.getSize();
					}
					if (checkPresenceVector(5))
					{
						m_ExposureModes.decode(bytes, pos);
						pos += m_ExposureModes.getSize();
					}
					if (checkPresenceVector(6))
					{
						m_MeteringModes.decode(bytes, pos);
						pos += m_MeteringModes.getSize();
					}
					if (checkPresenceVector(7))
					{
						m_MinimumShutterSpeed = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(8))
					{
						m_MaximumShutterSpeed = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(9))
					{
						m_MinimumAperture = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(10))
					{
						m_MaximumAperture = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(11))
					{
						m_MinimumFocalLength = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(12))
					{
						m_MaximumFocalLength = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(13))
					{
						m_LightSensitivityLevels.decode(bytes, pos);
						pos += m_LightSensitivityLevels.getSize();
					}
					if (checkPresenceVector(14))
					{
						m_ImageStabilization = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
				}
				
				public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec assign(VisualSensorCapabilitiesRec value)
				{
					m_PresenceVector = value.m_PresenceVector;
					m_SensorID = value.m_SensorID;
					m_SensorName = value.m_SensorName;
					m_SupportedStates = value.m_SupportedStates;
					m_ZoomModes = value.m_ZoomModes;
					m_FocusModes = value.m_FocusModes;
					m_WhiteBalance = value.m_WhiteBalance;
					m_ImagingModes = value.m_ImagingModes;
					m_ExposureModes = value.m_ExposureModes;
					m_MeteringModes = value.m_MeteringModes;
					m_MinimumShutterSpeed = value.m_MinimumShutterSpeed;
					m_MaximumShutterSpeed = value.m_MaximumShutterSpeed;
					m_MinimumAperture = value.m_MinimumAperture;
					m_MaximumAperture = value.m_MaximumAperture;
					m_MinimumFocalLength = value.m_MinimumFocalLength;
					m_MaximumFocalLength = value.m_MaximumFocalLength;
					m_LightSensitivityLevels = value.m_LightSensitivityLevels;
					m_ImageStabilization = value.m_ImageStabilization;
					
					return this;
				}
				
				public boolean isEqual(VisualSensorCapabilitiesRec value)
				{
					if (!m_PresenceVector.equals(value.m_PresenceVector))
					{
						return false;
					}
					if (m_SensorID != value.getSensorID())
					{
						return false;
					}
					if ((m_SensorName.length() != value.m_SensorName.length()) || (m_SensorName.compareTo(value.m_SensorName) != 0))
					{
						return false;
					}
					
					if (!m_SupportedStates.isEqual(value.getSupportedStates()))
					{
						return false;
					}
					
					if (!m_ZoomModes.isEqual(value.getZoomModes()))
					{
						return false;
					}
					
					if (!m_FocusModes.isEqual(value.getFocusModes()))
					{
						return false;
					}
					
					if (!m_WhiteBalance.isEqual(value.getWhiteBalance()))
					{
						return false;
					}
					
					if (!m_ImagingModes.isEqual(value.getImagingModes()))
					{
						return false;
					}
					
					if (!m_ExposureModes.isEqual(value.getExposureModes()))
					{
						return false;
					}
					
					if (!m_MeteringModes.isEqual(value.getMeteringModes()))
					{
						return false;
					}
					if (m_MinimumShutterSpeed != value.getMinimumShutterSpeed())
					{
						return false;
					}
					if (m_MaximumShutterSpeed != value.getMaximumShutterSpeed())
					{
						return false;
					}
					if (m_MinimumAperture != value.getMinimumAperture())
					{
						return false;
					}
					if (m_MaximumAperture != value.getMaximumAperture())
					{
						return false;
					}
					if (m_MinimumFocalLength != value.getMinimumFocalLength())
					{
						return false;
					}
					if (m_MaximumFocalLength != value.getMaximumFocalLength())
					{
						return false;
					}
					
					if (!m_LightSensitivityLevels.isEqual(value.getLightSensitivityLevels()))
					{
						return false;
					}
					if (m_ImageStabilization != value.getImageStabilization())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(VisualSensorCapabilitiesRec value)
				{
					return !this.isEqual(value);
				}
				
				public VisualSensorCapabilitiesRec()
				{
					m_parent = null;
					m_PresenceVector = new BitSet();
					m_PresenceVectorTemp = 0;
					m_SensorID = 0;
					m_SensorName = new String();
					m_SupportedStates = new SupportedStates();
					m_SupportedStates.setParent(this);
					m_ZoomModes = new ZoomModes();
					m_ZoomModes.setParent(this);
					m_FocusModes = new FocusModes();
					m_FocusModes.setParent(this);
					m_WhiteBalance = new WhiteBalance();
					m_WhiteBalance.setParent(this);
					m_ImagingModes = new ImagingModes();
					m_ImagingModes.setParent(this);
					m_ExposureModes = new ExposureModes();
					m_ExposureModes.setParent(this);
					m_MeteringModes = new MeteringModes();
					m_MeteringModes.setParent(this);
					m_MinimumShutterSpeed = 0;
					m_MaximumShutterSpeed = 0;
					m_MinimumAperture = 0;
					m_MaximumAperture = 0;
					m_MinimumFocalLength = 0;
					m_MaximumFocalLength = 0;
					m_LightSensitivityLevels = new LightSensitivityLevels();
					m_LightSensitivityLevels.setParent(this);
					m_ImageStabilization = 0;
				}
				
				public VisualSensorCapabilitiesRec(VisualSensorCapabilitiesRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_PresenceVector = new BitSet();
					m_PresenceVectorTemp = 0;
					m_SensorID = 0;
					m_SensorName = new String();
					m_SupportedStates = new SupportedStates();
					m_SupportedStates.setParent(this);
					m_ZoomModes = new ZoomModes();
					m_ZoomModes.setParent(this);
					m_FocusModes = new FocusModes();
					m_FocusModes.setParent(this);
					m_WhiteBalance = new WhiteBalance();
					m_WhiteBalance.setParent(this);
					m_ImagingModes = new ImagingModes();
					m_ImagingModes.setParent(this);
					m_ExposureModes = new ExposureModes();
					m_ExposureModes.setParent(this);
					m_MeteringModes = new MeteringModes();
					m_MeteringModes.setParent(this);
					m_MinimumShutterSpeed = 0;
					m_MaximumShutterSpeed = 0;
					m_MinimumAperture = 0;
					m_MaximumAperture = 0;
					m_MinimumFocalLength = 0;
					m_MaximumFocalLength = 0;
					m_LightSensitivityLevels = new LightSensitivityLevels();
					m_LightSensitivityLevels.setParent(this);
					m_ImageStabilization = 0;
					
					/// Copy the values
					m_PresenceVector = value.m_PresenceVector;
					m_SensorID = value.m_SensorID;
					m_SensorName = value.m_SensorName;
					m_SupportedStates = value.m_SupportedStates;
					m_ZoomModes = value.m_ZoomModes;
					m_FocusModes = value.m_FocusModes;
					m_WhiteBalance = value.m_WhiteBalance;
					m_ImagingModes = value.m_ImagingModes;
					m_ExposureModes = value.m_ExposureModes;
					m_MeteringModes = value.m_MeteringModes;
					m_MinimumShutterSpeed = value.m_MinimumShutterSpeed;
					m_MaximumShutterSpeed = value.m_MaximumShutterSpeed;
					m_MinimumAperture = value.m_MinimumAperture;
					m_MaximumAperture = value.m_MaximumAperture;
					m_MinimumFocalLength = value.m_MinimumFocalLength;
					m_MaximumFocalLength = value.m_MaximumFocalLength;
					m_LightSensitivityLevels = value.m_LightSensitivityLevels;
					m_ImageStabilization = value.m_ImageStabilization;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<VisualSensorCapabilitiesRec> m_VisualSensorCapabilitiesRec;
		
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
				return (long) m_VisualSensorCapabilitiesRec.size();
			}
			
			public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList.VisualSensorCapabilitiesRec getElement(int index)
			{
				return m_VisualSensorCapabilitiesRec.get(index);
			}
			
			public void setElement(int index, VisualSensorCapabilitiesRec value)
			{
				if(m_VisualSensorCapabilitiesRec.size()-1 < index)
				{
					return;
				}
				
				m_VisualSensorCapabilitiesRec.set(index, value);
				m_VisualSensorCapabilitiesRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(VisualSensorCapabilitiesRec value)
			{
				m_VisualSensorCapabilitiesRec.add(value);
				m_VisualSensorCapabilitiesRec.get(m_VisualSensorCapabilitiesRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_VisualSensorCapabilitiesRec.size()-1 < index)
				{
					return 1;
				}
				
				m_VisualSensorCapabilitiesRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_VisualSensorCapabilitiesRec.remove(m_VisualSensorCapabilitiesRec.size()-1);
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
				for (int i = 0; i < m_VisualSensorCapabilitiesRec.size(); i++)
				{
					size += m_VisualSensorCapabilitiesRec.get(i).getSize();
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
				
				int size = (int) m_VisualSensorCapabilitiesRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_VisualSensorCapabilitiesRec.size(); i++)
				{
					m_VisualSensorCapabilitiesRec.get(i).encode(bytes, pos);
					pos += m_VisualSensorCapabilitiesRec.get(i).getSize();
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
				m_VisualSensorCapabilitiesRec = new ArrayList<VisualSensorCapabilitiesRec>();
				for (int i = 0; i <  size; i++)
				{
					VisualSensorCapabilitiesRec item = new VisualSensorCapabilitiesRec();
					item.decode(bytes, pos);
					m_VisualSensorCapabilitiesRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList assign(VisualSensorCapabilitiesList value)
			{
				m_VisualSensorCapabilitiesRec.clear();
				
				for (int i = 0; i < value.m_VisualSensorCapabilitiesRec.size(); i++)
				{
					m_VisualSensorCapabilitiesRec.add(value.m_VisualSensorCapabilitiesRec.get(i));
					m_VisualSensorCapabilitiesRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(VisualSensorCapabilitiesList value)
			{
				for (int i = 0; i < m_VisualSensorCapabilitiesRec.size(); i++)
				{
					if (!m_VisualSensorCapabilitiesRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(VisualSensorCapabilitiesList value)
			{
				return !this.isEqual(value);
			}
			
			public VisualSensorCapabilitiesList()
			{
				m_parent = null;
				m_VisualSensorCapabilitiesRec = new ArrayList<VisualSensorCapabilitiesRec>();
				for (int i = 0; i < m_VisualSensorCapabilitiesRec.size(); i++)
				{
					m_VisualSensorCapabilitiesRec.get(i).setParent(this);
				}
			}
			
			public VisualSensorCapabilitiesList(VisualSensorCapabilitiesList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_VisualSensorCapabilitiesRec = new ArrayList<VisualSensorCapabilitiesRec>();
				for (int i = 0; i < m_VisualSensorCapabilitiesRec.size(); i++)
				{
					m_VisualSensorCapabilitiesRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_VisualSensorCapabilitiesRec.clear();
				
				for (int i = 0; i < value.m_VisualSensorCapabilitiesRec.size(); i++)
				{
					m_VisualSensorCapabilitiesRec.add(value.m_VisualSensorCapabilitiesRec.get(i));
					m_VisualSensorCapabilitiesRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected VisualSensorCapabilitiesList m_VisualSensorCapabilitiesList;
	
		public ReportVisualSensorCapabilities.Body.VisualSensorCapabilitiesList getVisualSensorCapabilitiesList()
		{
			return m_VisualSensorCapabilitiesList;
		}
		
		public void setVisualSensorCapabilitiesList(VisualSensorCapabilitiesList value)
		{
			m_VisualSensorCapabilitiesList = value;
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
			
			size += m_VisualSensorCapabilitiesList.getSize();
			
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
			
			m_VisualSensorCapabilitiesList.encode(bytes, pos);
			pos += m_VisualSensorCapabilitiesList.getSize();
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
			
			m_VisualSensorCapabilitiesList.decode(bytes, pos);
			pos += m_VisualSensorCapabilitiesList.getSize();
		}
		
		public ReportVisualSensorCapabilities.Body assign(Body value)
		{
			m_VisualSensorCapabilitiesList = value.m_VisualSensorCapabilitiesList;
			m_VisualSensorCapabilitiesList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_VisualSensorCapabilitiesList.isEqual(value.m_VisualSensorCapabilitiesList))
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
			m_VisualSensorCapabilitiesList = new VisualSensorCapabilitiesList();
			m_VisualSensorCapabilitiesList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_VisualSensorCapabilitiesList = new VisualSensorCapabilitiesList();
			m_VisualSensorCapabilitiesList.setParent(this);
			
			/// Copy the values
			m_VisualSensorCapabilitiesList = value.m_VisualSensorCapabilitiesList;
			m_VisualSensorCapabilitiesList.setParent(this);
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
	public ReportVisualSensorCapabilities.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportVisualSensorCapabilities.Body getBody()
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
	
	public ReportVisualSensorCapabilities setAs(ReportVisualSensorCapabilities value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportVisualSensorCapabilities value)
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
	
	public boolean notEquals(ReportVisualSensorCapabilities value)
	{
		return !isEqual(value);
	}
	
	public ReportVisualSensorCapabilities()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportVisualSensorCapabilities(ReportVisualSensorCapabilities value)
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
